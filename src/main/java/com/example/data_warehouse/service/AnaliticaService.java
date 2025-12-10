package com.example.data_warehouse.service;

import com.example.data_warehouse.dto.KpiResumenDto;
import com.example.data_warehouse.dto.PuntoSerieTemporalDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Service
public class AnaliticaService {

    private final JdbcTemplate jdbcTemplate;

    public AnaliticaService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public KpiResumenDto obtenerKpis(LocalDate desde, LocalDate hasta) {
        String sql = """
            SELECT
              COALESCE(SUM(f.total), 0)         AS total_ventas,
              COUNT(*)                          AS total_transacciones,
              COUNT(DISTINCT f.sk_cliente)      AS clientes_unicos,
              COALESCE(AVG(f.total), 0)         AS ticket_promedio
            FROM dw.fct_ventas f
            JOIN dw.dim_fecha d ON f.sk_fecha = d.sk_fecha
            WHERE d.fecha BETWEEN ? AND ?
            """;

        return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                new KpiResumenDto(
                        rs.getDouble("total_ventas"),
                        rs.getLong("total_transacciones"),
                        rs.getLong("clientes_unicos"),
                        rs.getDouble("ticket_promedio")
                ), desde, hasta);
    }

    public List<PuntoSerieTemporalDto> obtenerSerieVentasDiarias(LocalDate desde, LocalDate hasta) {
        String sql = """
            SELECT
              d.fecha,
              COALESCE(SUM(f.total), 0) AS total_ventas
            FROM dw.fct_ventas f
            JOIN dw.dim_fecha d ON f.sk_fecha = d.sk_fecha
            WHERE d.fecha BETWEEN ? AND ?
            GROUP BY d.fecha
            ORDER BY d.fecha
            """;

        return jdbcTemplate.query(sql, (rs, rowNum) -> mapPuntoSerie(rs), desde, hasta);
    }

    private PuntoSerieTemporalDto mapPuntoSerie(ResultSet rs) throws SQLException {
        return new PuntoSerieTemporalDto(
                rs.getDate("fecha").toLocalDate(),
                rs.getDouble("total_ventas")
        );
    }
}

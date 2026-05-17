package com.example.demo.dto.v1;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

@Schema(description = "Oficina table vSIAF")
public class OficinaDTO {
    @Schema(description = "Entidad", example = "AAPOS")
    private String Entidad;
    @Schema(description = "Unidad", example = "ACTIVOS FIJOS")
    private String Unidad;
    private int CodOfic;
    private String NomOfic;
    private String Observ;
    private Date Feult;
    private String Usuar;
    private int Api_Estado;
}

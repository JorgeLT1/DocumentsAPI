package com.example.documentsapi.data.remote

import com.example.documentsapi.data.dto.DocumentoDto
import retrofit2.http.GET

interface DocumentoApi {
    @GET("documentos")
    suspend fun getDocumentos():List<DocumentoDto>
}
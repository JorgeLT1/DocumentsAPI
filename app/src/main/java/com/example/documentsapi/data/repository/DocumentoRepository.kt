package com.example.documentsapi.data.repository

import com.example.documentsapi.data.dto.DocumentoDto
import com.example.documentsapi.data.remote.DocumentoApi
import com.example.documentsapi.util.Resource
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class DocumentoRepository @Inject constructor(private val api: DocumentoApi) {
    fun getDocumento(): Flow<Resource<List<DocumentoDto>>> = flow {
        try{
            emit(Resource.Loading())

            val documento = api.getDocumentos()

            emit(Resource.Success(documento))
        }catch (e: HttpException){
            emit(Resource.Error(e.message ?: "Error HTTP GENERAL"))

        }catch (e: IOException){
            emit(Resource.Error(e.message ?: "Verificar tu conexion a internet"))
        }
    }
}
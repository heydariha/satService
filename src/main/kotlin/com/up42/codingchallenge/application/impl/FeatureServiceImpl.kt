package com.up42.codingchallenge.application.impl

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.up42.codingchallenge.application.api.FeatureService
import com.up42.codingchallenge.persistence.FeatureCollection
import org.springframework.core.io.ClassPathResource
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Component("featureService")
class FeatureServiceImpl : FeatureService {

    override fun getFeatures(): List<FeatureCollection.Feature> = getAllFeatures()

    override fun getFeaturesById(featureId: UUID): FeatureCollection.Feature? =
        getAllFeatures().first() { it.id == featureId }


    private fun getAllFeatures() = ClassPathResource("/static/source-data.json").file.readText()
        .let { jsonString ->
            jacksonObjectMapper().readValue<List<FeatureCollection>>(jsonString)
        }.flatMap {
            it.features
        }.map {
            it.apply {
                id = properties?.id
                timestamp = properties?.timestamp
                beginViewingDate = properties?.acquisition?.beginViewingDate
                endViewingDate = properties?.acquisition?.endViewingDate
                missionName = properties?.acquisition?.missionName
            }
        }.ifEmpty {
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No features found")
        }
}
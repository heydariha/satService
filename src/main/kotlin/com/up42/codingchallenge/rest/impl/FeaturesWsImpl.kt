package com.up42.codingchallenge.rest.impl

import com.up42.codingchallenge.application.api.FeatureService
import com.up42.codingchallenge.persistence.FeatureCollection
import com.up42.codingchallenge.rest.api.FeaturesWs
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.util.*


@RestController
class FeaturesWsImpl(val featureService: FeatureService) : FeaturesWs {

    override fun getFeatures(): List<FeatureCollection.Feature> = featureService.getFeatures()

    override fun getFeatureImage(featureId: UUID): ResponseEntity<ByteArray?>? {
        return ResponseEntity.ok()
            .contentType(MediaType.IMAGE_PNG)
            .body(Base64.getDecoder().decode(
                featureService.getFeaturesById(featureId)!!.
                properties!!.quicklook!!.toByteArray()))
    }
}
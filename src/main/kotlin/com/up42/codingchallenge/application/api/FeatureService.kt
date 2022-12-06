package com.up42.codingchallenge.application.api

import com.up42.codingchallenge.persistence.FeatureCollection
import java.util.*

interface FeatureService {
    fun getFeatures(): List<FeatureCollection.Feature>

    fun getFeaturesById(featureId: UUID): FeatureCollection.Feature?
}
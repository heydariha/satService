package com.up42.codingchallenge.rest.impl

import io.restassured.RestAssured
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers
import org.hamcrest.Matchers.instanceOf
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FeaturesWsImplTest {

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @LocalServerPort
    var port: Int = 0

    data class ExpectedFeature(
        val id: String,
        val timestamp: Long,
        val beginViewingDate: Long,
        val endViewingDate: Long,
        val missionName: String
    )

    lateinit var expectedFeatures: Map<Int, ExpectedFeature>

    @BeforeAll
    fun beforeAll() {
        RestAssured.port = port
        expectedFeatures = mapOf(
            0 to ExpectedFeature(
                id = "39c2f29e-c0f8-4a39-a98b-deed547d6aea",
                timestamp = 1554831167697,
                beginViewingDate = 1554831167697,
                endViewingDate = 1554831202043,
                missionName = "Sentinel-1B"
            ),
            1 to ExpectedFeature(
                id = "cf5dbe37-ab95-4af1-97ad-2637aec4ddf0",
                timestamp = 1556904743783,
                beginViewingDate = 1556904743783,
                endViewingDate = 1556904768781,
                missionName = "Sentinel-1B"
            ),
            2 to ExpectedFeature(
                id = "ca81d759-0b8c-4b3f-a00a-0908a3ddd655",
                timestamp = 1558155123786,
                beginViewingDate = 1558155123786,
                endViewingDate = 1558155148785,
                missionName = "Sentinel-1A"
            ),
            3 to ExpectedFeature(
                id = "0b598c52-7bf2-4df0-9d09-94229cdfbc0b",
                timestamp = 1560661222337,
                beginViewingDate = 1560661222337,
                endViewingDate = 1560661247336,
                missionName = "Sentinel-1A"
            ),
            4 to ExpectedFeature(
                id = "aeaa71d6-c549-4620-99ce-f8cae750b8d5",
                timestamp = 1560015145495,
                beginViewingDate = 1560015145495,
                endViewingDate = 1560015170493,
                missionName = "Sentinel-1B"
            ),
            5 to ExpectedFeature(
                id = "12d0b505-2c70-4420-855c-936d05c55669",
                timestamp = 1555477219508,
                beginViewingDate = 1555477219508,
                endViewingDate = 1555477244506,
                missionName = "Sentinel-1A"
            ),
            6 to ExpectedFeature(
                id = "7f23a853-76a8-4787-a2ba-fdfe93e74165",
                timestamp = 1561051946263,
                beginViewingDate = 1561051946263,
                endViewingDate = 1561051971261,
                missionName = "Sentinel-1B"
            ),
            7 to ExpectedFeature(
                id = "b3ac34e1-12e6-4dee-9e21-b717f472fcfd",
                timestamp = 1557941519219,
                beginViewingDate = 1557941519219,
                endViewingDate = 1557941544218,
                missionName = "Sentinel-1B"
            ),
            8 to ExpectedFeature(
                id = "6df9b09a-3a93-4064-bf9f-47e5809b0ffe",
                timestamp = 1557118373086,
                beginViewingDate = 1557118373086,
                endViewingDate = 1557118398085,
                missionName = "Sentinel-1A"
            ),
            9 to ExpectedFeature(
                id = "2ed68fe5-f719-48c3-aa27-b0cc155f06cb",
                timestamp = 1560015170494,
                beginViewingDate = 1560015170494,
                endViewingDate = 1560015204843,
                missionName = "Sentinel-1B"
            ),
            10 to ExpectedFeature(
                id = "f556abfe-5558-4d3a-9849-c0de4d2766fd",
                timestamp = 1561051971263,
                beginViewingDate = 1561051971263,
                endViewingDate = 1561052005606,
                missionName = "Sentinel-1B"
            ),
            11 to ExpectedFeature(
                id = "63fded50-842f-4384-ac65-e83d584beb4c",
                timestamp = 1556904768782,
                beginViewingDate = 1556904768782,
                endViewingDate = 1556904803124,
                missionName = "Sentinel-1B"
            ),
            12 to ExpectedFeature(
                id = "b0d3bf6a-ff54-49e0-a4cb-e57dcb68d3b5",
                timestamp = 1558155148786,
                beginViewingDate = 1558155148786,
                endViewingDate = 1558155173785,
                missionName = "Sentinel-1A"
            ),
            13 to ExpectedFeature(
                id = "08a190bf-8c7e-4e94-a22c-7f3be11f642c",
                timestamp = 1555044772083,
                beginViewingDate = 1555044772083,
                endViewingDate = 1555044797082,
                missionName = "Sentinel-1A"
            ),
        )
    }

    @Test
    fun `should return all features`() {
        data class ExpectedFeature(
            val id: String,
            val timestamp: Long,
            val beginViewingDate: Long,
            val endViewingDate: Long,
            val missionName: String
        )

        val expectedFeatures = mapOf(
            0 to ExpectedFeature(
                id = "39c2f29e-c0f8-4a39-a98b-deed547d6aea",
                timestamp = 1554831167697,
                beginViewingDate = 1554831167697,
                endViewingDate = 1554831202043,
                missionName = "Sentinel-1B"
            ),
            1 to ExpectedFeature(
                id = "cf5dbe37-ab95-4af1-97ad-2637aec4ddf0",
                timestamp = 1556904743783,
                beginViewingDate = 1556904743783,
                endViewingDate = 1556904768781,
                missionName = "Sentinel-1B"
            ),
            2 to ExpectedFeature(
                id = "ca81d759-0b8c-4b3f-a00a-0908a3ddd655",
                timestamp = 1558155123786,
                beginViewingDate = 1558155123786,
                endViewingDate = 1558155148785,
                missionName = "Sentinel-1A"
            ),
            3 to ExpectedFeature(
                id = "0b598c52-7bf2-4df0-9d09-94229cdfbc0b",
                timestamp = 1560661222337,
                beginViewingDate = 1560661222337,
                endViewingDate = 1560661247336,
                missionName = "Sentinel-1A"
            ),
            4 to ExpectedFeature(
                id = "aeaa71d6-c549-4620-99ce-f8cae750b8d5",
                timestamp = 1560015145495,
                beginViewingDate = 1560015145495,
                endViewingDate = 1560015170493,
                missionName = "Sentinel-1B"
            ),
            5 to ExpectedFeature(
                id = "12d0b505-2c70-4420-855c-936d05c55669",
                timestamp = 1555477219508,
                beginViewingDate = 1555477219508,
                endViewingDate = 1555477244506,
                missionName = "Sentinel-1A"
            ),
            6 to ExpectedFeature(
                id = "7f23a853-76a8-4787-a2ba-fdfe93e74165",
                timestamp = 1561051946263,
                beginViewingDate = 1561051946263,
                endViewingDate = 1561051971261,
                missionName = "Sentinel-1B"
            ),
            7 to ExpectedFeature(
                id = "b3ac34e1-12e6-4dee-9e21-b717f472fcfd",
                timestamp = 1557941519219,
                beginViewingDate = 1557941519219,
                endViewingDate = 1557941544218,
                missionName = "Sentinel-1B"
            ),
            8 to ExpectedFeature(
                id = "6df9b09a-3a93-4064-bf9f-47e5809b0ffe",
                timestamp = 1557118373086,
                beginViewingDate = 1557118373086,
                endViewingDate = 1557118398085,
                missionName = "Sentinel-1A"
            ),
            9 to ExpectedFeature(
                id = "2ed68fe5-f719-48c3-aa27-b0cc155f06cb",
                timestamp = 1560015170494,
                beginViewingDate = 1560015170494,
                endViewingDate = 1560015204843,
                missionName = "Sentinel-1B"
            ),
            10 to ExpectedFeature(
                id = "f556abfe-5558-4d3a-9849-c0de4d2766fd",
                timestamp = 1561051971263,
                beginViewingDate = 1561051971263,
                endViewingDate = 1561052005606,
                missionName = "Sentinel-1B"
            ),
            11 to ExpectedFeature(
                id = "63fded50-842f-4384-ac65-e83d584beb4c",
                timestamp = 1556904768782,
                beginViewingDate = 1556904768782,
                endViewingDate = 1556904803124,
                missionName = "Sentinel-1B"
            ),
            12 to ExpectedFeature(
                id = "b0d3bf6a-ff54-49e0-a4cb-e57dcb68d3b5",
                timestamp = 1558155148786,
                beginViewingDate = 1558155148786,
                endViewingDate = 1558155173785,
                missionName = "Sentinel-1A"
            ),
            13 to ExpectedFeature(
                id = "08a190bf-8c7e-4e94-a22c-7f3be11f642c",
                timestamp = 1555044772083,
                beginViewingDate = 1555044772083,
                endViewingDate = 1555044797082,
                missionName = "Sentinel-1A"
            ),
        )

        RestAssured.given()
            .get("/features")
            .then()
            .statusCode(200)
            .also { validatableResponse ->
                expectedFeatures.forEach { feature ->
                    validatableResponse.body("id[${feature.key}]", Matchers.equalTo(feature.value.id))
                        .body("timestamp[${feature.key}]", Matchers.equalTo(feature.value.timestamp))
                        .body("beginViewingDate[${feature.key}]", Matchers.equalTo(feature.value.beginViewingDate))
                        .body("endViewingDate[${feature.key}]", Matchers.equalTo(feature.value.endViewingDate))
                        .body("missionName[${feature.key}]", Matchers.equalTo(feature.value.missionName))
                }
            }
    }

    @Test
    fun `get all features should be successful`() {
        //WHEN
        val response = restTemplate.getForEntity("/features", List::class.java)

        //THEN
        assertTrue(response.statusCode == HttpStatus.OK)
        assertTrue(response.body!!.size == 14)
        assertThat(response.body, instanceOf(List::class.java))
    }


    @Test
    fun `get feature image`() {
        //Given
        val featureId = expectedFeatures.get(1)!!.id

        //WHEN
        val response = restTemplate.getForEntity("/features/${featureId}/quicklook", ByteArray::class.java)

        //THEN
        assertTrue(response.statusCode == HttpStatus.OK)
        assertEquals(response.headers.get("Content-Type")!![0], MediaType.IMAGE_PNG.toString())
    }

}
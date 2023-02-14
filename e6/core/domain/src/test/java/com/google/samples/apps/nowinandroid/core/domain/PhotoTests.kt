package com.google.samples.apps.nowinandroid.core.domain

import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test
import ven.petstore.core.domain.model.animal.Media

class PhotoTests {

    private val mediumPhoto = "mediumPhoto"
    private val fullPhoto = "fullPhoto"
    private val invalidPhoto = "" // Photo.isValidPhoto()

    @Test
    fun photo_getSmallestAvailablePhoto_hasMediumPhoto() = runTest {
       // Given
        val photo = Media.Photo(mediumPhoto, fullPhoto)
        val expectedValue = mediumPhoto

        // When
        val smallestPhoto = photo.getSmallestAvailablePhoto()

      // Then
        assertEquals(smallestPhoto, expectedValue)
    }
}
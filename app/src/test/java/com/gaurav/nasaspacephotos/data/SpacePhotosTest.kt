package com.gaurav.nasaspacephotos.data

import com.gaurav.nasaspacephotos.data.model.SpacePhotos

/**
 * Created by gauravgoel on 10/February/2021
 */
class SpacePhotosTest {

    companion object{
        private const val copyright = "Anton Komlev"
        private const val date = "2019-12-07"
        private const val explanation = "TIn time stars trace lines through the night sky on a rotating planet. Taken over two hours or more, these digitally added consecutive exposures were made with a camera and wide angle lens fixed to a tripod near Orel farm, Primorsky Krai, Russia, planet Earth. The stars trail in concentric arcs around the planet's south celestial pole below the scene's horizon, and north celestial pole off the frame at the upper right. Combined, the many short exposures also bring out the pretty star colours. Bluish trails are from stars hotter than Earth's Sun, while yellowish trails are from cooler stars. A long time ago this tree blossomed, but now reveals the passage of time in the wrinkled and weathered lines of its remains."
        private const val hdurl = "https://apod.nasa.gov/apod/image/1912/LinesOfTimeKomlev.jpg"
        private const val media_type = "image"
        private const val service_version = "v1"
        private const val title = "Lines of Time"
        private const val url = "https://apod.nasa.gov/apod/image/1912/LinesOfTimeKomlev1100.jpg"

        val photos = SpacePhotos(copyright,date, explanation, hdurl, media_type, service_version, title, url)
    }
}
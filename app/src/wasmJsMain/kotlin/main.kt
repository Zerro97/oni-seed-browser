/*
 * ONI Seed Browser
 * Copyright (C) 2024 Stefan Oltmann
 * https://stefan-oltmann.de/oni-seed-browser
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.MessageEvent
import ui.App

@OptIn(ExperimentalComposeUiApi::class)
fun main() {

    CanvasBasedWindow(canvasElementId = "ComposeTarget") {

        val domain = document.domain

        println("Running on domain: $domain")

        val urlHash = remember {
            mutableStateOf(document.location?.hash?.drop(1)?.ifBlank { null })
        }

        window.onhashchange = {
            urlHash.value = it.newURL.substringAfter('#', "").ifBlank { null }
        }

        // Listener for locale change
        window.addEventListener("message") { event ->
            val messageEvent = event as MessageEvent
            val data = messageEvent.data
            println(data)
        }

        App(urlHash)
    }
}

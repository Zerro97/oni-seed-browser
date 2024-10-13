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

package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import model.Asteroid
import model.World
import ui.theme.FillSpacer
import ui.theme.anthraticeTransparentBackgroundColor
import ui.theme.defaultRoundedCornerShape
import ui.theme.defaultSpacing
import ui.theme.lightGrayTransparentBorderColor
import kotlin.math.max

val widthPerWorld: Dp = 380.dp

@Composable
fun WorldView(
    world: World,
    index: Int,
    totalCount: Int,
    showStarMap: MutableState<World?>,
    showAsteroidMap: MutableState<Asteroid?>,
    showAsteroidDetails: MutableState<Asteroid?>,
    showTooltip: MutableState<Tooltip?>
) {

    val clipboardManager = LocalClipboardManager.current

    Column(
        verticalArrangement = Arrangement.spacedBy(defaultSpacing),
        modifier = Modifier
            .background(anthraticeTransparentBackgroundColor, defaultRoundedCornerShape)
            .border(0.dp, lightGrayTransparentBorderColor, defaultRoundedCornerShape)
    ) {

        val showMapClicked: (() -> Unit) = { showStarMap.value = world }

        CoordinateBox(
            index = index,
            totalCount = totalCount,
            coordinate = world.coordinate,
            showMapClicked = if (world.starMapEntriesSpacedOut != null)
                showMapClicked
            else
                null,
            shareClicked = {

                clipboardManager.setText(AnnotatedString(world.coordinate))

                println("SHARE")
            }
        )

        val asteroid = showAsteroidMap.value

        if (asteroid == null) {

            AsteroidsGrid(
                world,
                showAsteroidMap,
                showAsteroidDetails,
                showTooltip
            )
        }
    }
}

@Composable
private fun AsteroidsGrid(
    world: World,
    showAsteroidMap: MutableState<Asteroid?>,
    showAsteroidDetails: MutableState<Asteroid?>,
    showTooltip: MutableState<Tooltip?>
) {

    BoxWithConstraints(
        modifier = Modifier.padding(
            start = defaultSpacing,
            end = defaultSpacing,
            bottom = defaultSpacing
        )
    ) {

        val gridLayoutColumnCount = max(
            maxWidth.div(widthPerWorld).toInt(),
            1
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(defaultSpacing)
        ) {

            val firstAsteroid = world.asteroids.first()

            /* First Asteroid should span the whole column. */
            AsteroidView(
                asteroid = firstAsteroid,
                isStarterAstroid = true,
                isSelected = showAsteroidDetails.value == firstAsteroid,
                showTooltip = showTooltip,
                showDetails = {

                    if (showAsteroidDetails.value == firstAsteroid)
                        showAsteroidDetails.value = null
                    else
                        showAsteroidDetails.value = firstAsteroid
                },
                showMap = {
                    showAsteroidMap.value = firstAsteroid
                }
            )

            val remainingAsteroids = world.asteroids.drop(1)

            val asteroidsPerColumn = remainingAsteroids.chunked(gridLayoutColumnCount)

            for (asteroidsInColumn in asteroidsPerColumn) {

                Row(
                    horizontalArrangement = Arrangement.spacedBy(defaultSpacing)
                ) {

                    for (asteroid in asteroidsInColumn) {

                        Box(
                            modifier = Modifier.weight(1F)
                        ) {

                            AsteroidView(
                                asteroid = asteroid,
                                isStarterAstroid = false,
                                isSelected = showAsteroidDetails.value == asteroid,
                                showTooltip = showTooltip,
                                showDetails = {

                                    if (showAsteroidDetails.value == asteroid)
                                        showAsteroidDetails.value = null
                                    else
                                        showAsteroidDetails.value = asteroid
                                },
                                showMap = {
                                    showAsteroidMap.value = asteroid
                                }
                            )
                        }
                    }

                    val requiredSpacerCount = gridLayoutColumnCount - asteroidsInColumn.size

                    repeat(requiredSpacerCount) {
                        FillSpacer()
                    }
                }
            }
        }
    }
}

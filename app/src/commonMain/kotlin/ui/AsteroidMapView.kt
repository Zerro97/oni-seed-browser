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

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.defaultScrollbarStyle
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.min
import kotlinx.coroutines.launch
import model.Asteroid
import model.BiomePaths
import model.Geyser
import model.ZoneType
import oni_seed_browser.app.generated.resources.Res
import oni_seed_browser.app.generated.resources.background_space
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import ui.theme.DefaultSpacer
import ui.theme.anthraticeTransparentBackgroundColor
import ui.theme.defaultPadding
import ui.theme.defaultRoundedCornerShape
import ui.theme.defaultSpacing
import ui.theme.doubleSpacing
import ui.theme.hoverColor
import ui.theme.lightGray
import ui.theme.lightGrayTransparentBorderColor

@Composable
fun AsteroidMapPopup(
    asteroid: Asteroid,
    onCloseClicked: () -> Unit
) {

    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .background(Color.Black)
            .noRippleClickable {
                /* Ignore clicks */
            }
    ) {

        /* Background */
        Image(
            painter = painterResource(Res.drawable.background_space),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        CloseButton(
            onClick = onCloseClicked
        )

        val highlightedZoneType = remember { mutableStateOf<ZoneType?>(null) }
        val highlightedGeyser = remember { mutableStateOf<Geyser?>(null) }

        Column {

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxWidth()
            ) {

                Text(
                    text = stringResource(asteroid.id.displayName),
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            val biomePaths = BiomePaths.parse(asteroid.biomePaths)

            val geyserListLazyListState = rememberLazyListState()

            val sortedGeysers = asteroid.geysers.sortedBy { it.id }

            Row(
                horizontalArrangement = Arrangement.spacedBy(defaultSpacing),
                modifier = Modifier.defaultPadding()
            ) {

                AsteroidBiomeDetails(
                    biomePaths,
                    highlightedZoneType
                )

                Box(
                    modifier = Modifier.weight(1F)
                ) {

                    AsteroidMap(
                        asteroid = asteroid,
                        biomePaths = biomePaths,
                        iconSize = 32.dp,
                        enableClickListener = true,
                        onGeyserClick = {

                            coroutineScope.launch {

                                val clickedGeyserIndex = sortedGeysers.indexOf(it)

                                if (clickedGeyserIndex >= 0)
                                    geyserListLazyListState.animateScrollToItem(clickedGeyserIndex)
                            }
                        },
                        highlightedGeyser = highlightedGeyser,
                        highlightedZoneType = highlightedZoneType
                    )
                }

                AsteroidGeysersDetails(
                    sortedGeysers,
                    geyserListLazyListState,
                    highlightedGeyser
                )
            }
        }
    }
}

@Composable
fun AsteroidMap(
    asteroid: Asteroid,
    biomePaths: BiomePaths,
    iconSize: Dp,
    enableClickListener: Boolean,
    highlightedGeyser: MutableState<Geyser?>,
    highlightedZoneType: MutableState<ZoneType?>,
    onGeyserClick: ((Geyser) -> Unit)?,
    contentAlignment: Alignment = Alignment.Center
) {

    val halfIconSize: Dp = iconSize.div(2)

    val modifier = if (enableClickListener)
        Modifier.noRippleClickable {

            /* Clicking not on a geyser should deselect all selections. */
            highlightedGeyser.value = null
        }
    else
        Modifier

    BoxWithConstraints(
        contentAlignment = contentAlignment,
        modifier = Modifier
            .fillMaxSize()
            .then(modifier)
    ) {

        /* Don't render if too small to avoid issues. */
        if (maxWidth < 50.dp || maxHeight < 50.dp)
            return@BoxWithConstraints

        val density = LocalDensity.current.density

        val viewScale = min(
            maxHeight.value / asteroid.sizeY,
            maxWidth.value / asteroid.sizeX
        )

        Canvas(
            modifier = Modifier
                .size(
                    width = (asteroid.sizeX * viewScale).dp,
                    height = (asteroid.sizeY * viewScale).dp,
                )
                .border(0.dp, lightGrayTransparentBorderColor)
        ) {

            for ((zoneType, pointsLists) in biomePaths.polygonMap) {

                val isHighlighted = highlightedZoneType.value == zoneType

                for (points in pointsLists) {

                    val path = Path()

                    val startingPoint = points.first()

                    path.moveTo(
                        startingPoint.x * viewScale * density,
                        startingPoint.y * viewScale * density
                    )

                    for (point in points.drop(1)) {

                        path.lineTo(
                            point.x * viewScale * density,
                            point.y * viewScale * density
                        )
                    }

                    path.lineTo(
                        startingPoint.x * viewScale * density,
                        startingPoint.y * viewScale * density
                    )

                    /*
                     * Only color the highlighted zone
                     */
                    val color = if (highlightedZoneType.value == null)
                        zoneType.color
                    else if (isHighlighted)
                        zoneType.color
                    else
                        Color.LightGray

                    drawPath(path, color, 1.0f)
                }
            }
        }

        Box(
            modifier = Modifier
                .size(
                    width = (asteroid.sizeX * viewScale).dp,
                    height = (asteroid.sizeY * viewScale).dp,
                )
        ) {

            for (poi in asteroid.pointsOfInterest) {

                Image(
                    painter = painterResource(getPointOfInterestDrawable(poi.id)),
                    contentDescription = null,
                    modifier = Modifier
                        .offset(
                            x = (poi.x * viewScale).dp - halfIconSize,
                            y = (poi.y * viewScale).dp - halfIconSize
                        )
                        .size(iconSize)
                )
            }

            for (geyser in asteroid.geysers) {

                val isHighlighted = highlightedGeyser.value == geyser

                val geyserClickModifier = if (enableClickListener)
                    Modifier.noRippleClickable {

                        highlightedGeyser.value = geyser

                        onGeyserClick?.invoke(geyser)
                    }
                else
                    Modifier

                Image(
                    painter = painterResource(getGeyserDrawable(geyser.id)),
                    contentDescription = null,
                    modifier = Modifier
                        .offset(
                            x = (geyser.x * viewScale).dp - halfIconSize,
                            y = (geyser.y * viewScale).dp - halfIconSize
                        )
                        .size(iconSize)
                        .border(
                            if (isHighlighted)
                                2.dp
                            else
                                0.dp,
                            if (isHighlighted)
                                hoverColor
                            else
                                Color.Transparent,
                            CircleShape
                        )
                        then (geyserClickModifier)
                )
            }
        }
    }
}

@Composable
private fun AsteroidBiomeDetails(
    biomePaths: BiomePaths,
    highlightedZoneType: MutableState<ZoneType?>
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(300.dp)
            .fillMaxHeight()
            .background(anthraticeTransparentBackgroundColor, defaultRoundedCornerShape)
            .border(0.dp, lightGrayTransparentBorderColor, defaultRoundedCornerShape)
    ) {

        DefaultSpacer()

        Text(
            text = "Biome details",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onBackground,
        )

        DefaultSpacer()

        Box(
            modifier = Modifier
        ) {

            val scrollState = rememberScrollState()

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(defaultSpacing),
                modifier = Modifier.verticalScroll(scrollState)
            ) {

                val presentZoneTypes = biomePaths.polygonMap.keys.sorted()

                for (zoneType in presentZoneTypes) {

                    val isHighlighted = highlightedZoneType.value == zoneType

                    ZoneTypeDetail(
                        zoneType = zoneType,
                        modifier = Modifier
                            .noRippleClickable {

                                if (isHighlighted)
                                    highlightedZoneType.value = null
                                else
                                    highlightedZoneType.value = zoneType
                            }
                            .border(
                                if (isHighlighted)
                                    2.dp
                                else
                                    0.dp,
                                if (isHighlighted)
                                    hoverColor
                                else
                                    lightGrayTransparentBorderColor,
                                defaultRoundedCornerShape
                            )
                    )
                }

                DefaultSpacer()
            }

            VerticalScrollbar(
                adapter = rememberScrollbarAdapter(scrollState),
                modifier = Modifier.fillMaxHeight().align(Alignment.CenterEnd),
                style = defaultScrollbarStyle().copy(
                    unhoverColor = lightGray.copy(alpha = 0.4f),
                    hoverColor = lightGray
                )
            )
        }
    }
}

@Composable
private fun AsteroidGeysersDetails(
    geysers: List<Geyser>,
    geyserListLazyListState: LazyListState,
    highlightedGeyser: MutableState<Geyser?>
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(300.dp)
            .fillMaxHeight()
            .background(anthraticeTransparentBackgroundColor, defaultRoundedCornerShape)
            .border(0.dp, lightGrayTransparentBorderColor, defaultRoundedCornerShape)
    ) {

        DefaultSpacer()

        Text(
            text = "Geyser details",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onBackground,
        )

        DefaultSpacer()

        Box(
            modifier = Modifier
        ) {

            LazyColumn(
                state = geyserListLazyListState,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(defaultSpacing),
                contentPadding = PaddingValues(bottom = doubleSpacing)
            ) {

                items(geysers) { geyser ->

                    val isHighlighted = highlightedGeyser.value == geyser

                    GeyserDetail(
                        geyser = geyser,
                        modifier = Modifier
                            .noRippleClickable {

                                if (isHighlighted)
                                    highlightedGeyser.value = null
                                else
                                    highlightedGeyser.value = geyser
                            }
                            .border(
                                if (isHighlighted)
                                    2.dp
                                else
                                    0.dp,
                                if (isHighlighted)
                                    hoverColor
                                else
                                    lightGrayTransparentBorderColor,
                                defaultRoundedCornerShape
                            )
                    )
                }
            }

            VerticalScrollbar(
                adapter = rememberScrollbarAdapter(geyserListLazyListState),
                modifier = Modifier.fillMaxHeight().align(Alignment.CenterEnd),
                style = defaultScrollbarStyle().copy(
                    unhoverColor = lightGray.copy(alpha = 0.4f),
                    hoverColor = lightGray
                ),
            )
        }
    }
}

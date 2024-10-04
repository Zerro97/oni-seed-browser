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

package model

/**
 * See https://oxygennotincluded.fandom.com/wiki/Planetoid_Clusters
 */
enum class AsteroidType(
    val displayName: String
) {

    /* Base game */
    TERRA("Terra Asteroid"),
    CERES("Ceres Asteroid"),
    OCEANIA("Oceania Asteroid"),
    RIME("Rime Asteroid"),
    VERDANTE("Verdante Asteroid"),
    ARBORIA("Arboria Asteroid"),
    VOLCANEA("Volcanea Asteroid"),
    THE_BADLANDS("The Badlands Asteroid"),
    ARIDIO("Aridio Asteroid"),
    OASISSE("Oasisse Asteroid"),

    /* DLC Classic */
    SPACEDOUT_TERRA("Terra Asteroid"),
    SPACEDOUT_CERES("Ceres Asteroid"),
    SPACEDOUT_OCEANIA("Oceania Asteroid"),
    SPACEDOUT_RIME("Rime Asteroid"),

    /* DLC Moonlets */
    TERRANIA("Terrania Asteroid"),
    SQUELCHY("Squelchy Asteroid"),
    CERES_MINOR("Ceres Minor Asteroid"),
    FOLIA("Folia Asteroid"),
    QUAGMIRIS("Quagmiris Asteroid"),
    METALLIC_SWAMPY("Metallic Swampy Asteroid"),
    THE_DESOLANDS("The Desolands Asteroid"),
    FROZEN_FOREST("Frozen Forest Asteroid"),
    FLIPPED("Flipped Asteroid"),
    RADIOACTIVE_OCEAN("Radioactive Ocean Asteroid"),
    RADIOACTIVE_SWAMP("Radioactive Swamp Asteroid"),
    GLOWOOD_WASTELAND("Glowood Wasteland Asteroid"),
    RADIOACTIVE_FOREST("Radioactive Forest Asteroid"),
    STINKO_SWAMP("Stinko Swamp Asteroid"),
    RADIOACTIVE_TERRA("Radioactive Terra Asteroid"),
    RADIOACTIVE_TERRABOG_ASTEROID("Radioactive Terrabog Asteroid"),
    OILY_SWAMP("Oily Swamp Asteroid"),
    RUSTY_OIL("Rusty Oil Asteroid"),
    IRRADIATED_FOREST("Irradiated Forest Asteroid"),
    IRRADIATED_SWAMPY("Irradiated Swampy Asteroid"),
    IRRADIATED_MARSH_ASTEROID("Irradiated Marsh Asteroid"),
    TUNDRA("Tundra Asteroid"),
    MARSHY("Marshy Asteroid"),
    SUPERCONDUCTIVE("Superconductive Asteroid"),
    MOO("Moo Asteroid"),
    WATER("Water Asteroid"),
    REGOLITH("Regolith Asteroid");

    companion object {

        @Suppress("CyclomaticComplexMethod", "kotlin:S1479")
        fun of(worldName: String): AsteroidType = when (worldName) {

            /* Base game */
            "SandstoneDefault" -> TERRA
            "Oceania" -> OCEANIA
            "SandstoneFrozen" -> RIME
            "ForestLush" -> VERDANTE
            "ForestDefault" -> ARBORIA
            "VanillaArboria" -> ARBORIA
            "Badlands" -> THE_BADLANDS
            "ForestHot" -> ARIDIO
            "Volcanic" -> VOLCANEA

            // FIXME Bring in order

            /* DLC classic */
            "VanillaSandstoneDefault" -> SPACEDOUT_TERRA
            "VanillaOceania" -> SPACEDOUT_OCEANIA
            "VanillaAridio" -> ARIDIO
            "VanillaOasis" -> OASISSE
            "Oasis" -> OASISSE
            "VanillaSwampDefault" -> SQUELCHY
            "VanillaSandstoneFrozen" -> RIME
            "VanillaForestDefault" -> VERDANTE
            "VanillaVolcanic" -> VOLCANEA
            "VanillaBadlands" -> THE_BADLANDS

            /* DLC moonlets */
            "TerraMoonlet" -> TERRANIA
            "ForestMoonlet" -> FOLIA
            "SwampMoonlet" -> QUAGMIRIS

            "MiniMetallicSwampyStart" -> METALLIC_SWAMPY
            "MiniMetallicSwampy" -> METALLIC_SWAMPY
            "MiniBadlands" -> THE_DESOLANDS
            "MiniBadlandsStart" -> THE_DESOLANDS
            "MiniBadlandsWarp" -> THE_DESOLANDS
            "MiniForestFrozen" -> FROZEN_FOREST
            "MiniForestFrozenStart" -> FROZEN_FOREST
            "MiniForestFrozenWarp" -> FROZEN_FOREST
            "MiniFlipped" -> FLIPPED
            "MiniFlippedStart" -> FLIPPED
            "MiniFlippedWarp" -> FLIPPED
            "MiniRadioactiveOcean" -> RADIOACTIVE_OCEAN
            "MiniRadioactiveOceanStart" -> RADIOACTIVE_OCEAN
            "MiniRadioactiveOceanWarp" -> RADIOACTIVE_OCEAN
            "MediumRadioactiveVanillaWarpPlanet" -> RADIOACTIVE_SWAMP
            "MediumForestyWasteland" -> GLOWOOD_WASTELAND
            "MediumForestyRadioactiveVanillaWarpPlanet" -> RADIOACTIVE_FOREST
            "MediumSwampy" -> STINKO_SWAMP
            "MediumSandyRadioactiveVanillaWarpPlanet" -> RADIOACTIVE_TERRA
            "MediumSandySwamp" -> RADIOACTIVE_TERRABOG_ASTEROID
            "WarpOilySwamp" -> OILY_SWAMP
            "OilRichWarpTarget" -> RUSTY_OIL
            "IdealLandingSite" -> IRRADIATED_FOREST
            "SwampyLandingSite" -> IRRADIATED_SWAMPY
            "MetalHeavyLandingSite" -> IRRADIATED_MARSH_ASTEROID
            "TundraMoonlet" -> TUNDRA
            "MarshyMoonlet" -> MARSHY
            "NiobiumMoonlet" -> SUPERCONDUCTIVE
            "MooMoonlet" -> MOO
            "WaterMoonlet" -> WATER
            "RegolithMoonlet" -> REGOLITH
            "MiniRegolithMoonlet" -> REGOLITH
            "CeresBaseGameAsteroid" -> CERES
            "CeresClassicAsteroid" -> SPACEDOUT_CERES
            "CeresSpacedOutAsteroid" -> CERES_MINOR
            else -> error("Unknown world: $worldName")
        }
    }
}

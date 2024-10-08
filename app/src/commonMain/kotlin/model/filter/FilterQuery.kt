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

package model.filter

import kotlinx.serialization.Serializable
import model.AsteroidType
import model.Cluster
import model.Dlc
import model.filter.FilterRule.Companion.EMPTY
import serializer.ClusterSerializer

@Serializable
data class FilterQuery(

    @Serializable(with = ClusterSerializer::class)
    val cluster: Cluster?,

    val dlcs: List<Dlc>,

    /**
     * List of connected OR-rules.
     *
     * All rules in a list are connected with an OR-condition,
     * while all collections of rules lists are connected with AND.
     */
    val rules: List<List<FilterRule>>

) {

    fun setAsteroid(rulesIndex: Int, ruleIndex: Int, asteroidType: AsteroidType?): FilterQuery {

        val newRules = rules.toMutableList()

        val subRules = newRules[rulesIndex].toMutableList()

        newRules[rulesIndex] = subRules

        subRules[ruleIndex] = subRules[ruleIndex].copy(
            asteroid = asteroidType
        )

        return copy(
            rules = newRules
        )
    }

    fun setFilterItem(rulesIndex: Int, ruleIndex: Int, filterItem: FilterItem): FilterQuery {

        val newRules = rules.toMutableList()

        val subRules = newRules[rulesIndex].toMutableList()

        newRules[rulesIndex] = subRules

        subRules[ruleIndex] = subRules[ruleIndex].copy(
            geyserCount = filterItem as? FilterItemGeyserCount,
            geyserOutput = filterItem as? FilterItemGeyserOutput,
            worldTrait = filterItem as? FilterItemWorldTrait,
            spaceDestinationCount = filterItem as? FilterItemSpaceDestinationCount
        )

        return copy(
            rules = newRules
        )
    }

    fun addEmptyAndRule(): FilterQuery {

        val newRules = rules.toMutableList()

        newRules.add(listOf(EMPTY))

        return copy(
            rules = newRules
        )
    }

    fun addEmptyOrRule(rulesIndex: Int): FilterQuery {

        val rulesCopy = rules.toMutableList()

        val newRules = rules[rulesIndex].toMutableList()

        newRules.add(EMPTY)

        rulesCopy.set(rulesIndex, newRules)

        return copy(
            rules = rulesCopy
        )
    }

    fun removeRule(rulesIndex: Int, ruleIndex: Int): FilterQuery {

        val newRules = mutableListOf<List<FilterRule>>()

        for ((index, list) in rules.withIndex()) {

            /*
             * If the rule is in the list, we need to add
             * a copy with the rule removed.
             */
            if (index == rulesIndex) {

                val listCopy = list.toMutableList()

                listCopy.removeAt(ruleIndex)

                /*
                 * Add the list, but only if it's not empty
                 * after removing the rule.
                 */
                if (listCopy.isNotEmpty())
                    newRules.add(listCopy)

            } else {

                /*
                 * Otherwise we copy the list as is.
                 */
                newRules.add(list)
            }
        }

        return copy(
            rules = newRules
        )
    }

    companion object {

        val ALL = FilterQuery(
            cluster = null,
            dlcs = listOf(Dlc.FrostyPlanet),
            rules = emptyList()
        )
    }
}

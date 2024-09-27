package service

val fakeJsonSearchResponse: String = """
    {
      "page": 0,
      "pageSize": 10,
      "totalPages": 1926,
      "totalResults": 19253,
      "worlds": [
        {
          "coordinate": "BAD-A-233578862-0-0",
          "cluster": "BAD-A",
          "dlcs": [
            "SpacedOut",
            "FrostyPlanet"
          ],
          "asteroids": [
            {
              "id": "TerraMoonlet",
              "offsetX": 0,
              "offsetY": 0,
              "sizeX": 160,
              "sizeY": 274,
              "worldTraits": [],
              "pointsOfInterest": [
                {
                  "id": "Headquarters",
                  "posX": 81,
                  "posY": 118
                },
                {
                  "id": "WarpConduitSender",
                  "posX": 27,
                  "posY": 125
                },
                {
                  "id": "WarpConduitReceiver",
                  "posX": 36,
                  "posY": 92
                },
                {
                  "id": "WarpPortal",
                  "posX": 125,
                  "posY": 117
                },
                {
                  "id": "WarpReceiver",
                  "posX": 126,
                  "posY": 111
                }
              ],
              "geysers": [
                {
                  "emitRate": 9709.374,
                  "idleTime": 296.35672,
                  "eruptionTime": 114.018379,
                  "dormancyCycles": 56.0820961,
                  "activeCycles": 97.62378,
                  "id": "steam",
                  "posX": 135,
                  "posY": 89
                },
                {
                  "emitRate": 5108.88672,
                  "idleTime": 252.654419,
                  "eruptionTime": 246.426147,
                  "dormancyCycles": 51.0973663,
                  "activeCycles": 79.90547,
                  "id": "slush_water",
                  "posX": 90,
                  "posY": 189
                },
                {
                  "emitRate": 8482.265,
                  "idleTime": 368.7467,
                  "eruptionTime": 183.49939,
                  "dormancyCycles": 41.9170837,
                  "activeCycles": 70.0096741,
                  "id": "slush_salt_water",
                  "posX": 19,
                  "posY": 165
                },
                {
                  "emitRate": 239.567261,
                  "idleTime": 189.446213,
                  "eruptionTime": 464.319366,
                  "dormancyCycles": 61.91021,
                  "activeCycles": 85.14461,
                  "id": "methane",
                  "posX": 114,
                  "posY": 180
                },
                {
                  "emitRate": 133791.469,
                  "idleTime": 7711.32666,
                  "eruptionTime": 56.5961151,
                  "dormancyCycles": 38.9392052,
                  "activeCycles": 49.6222,
                  "id": "small_volcano",
                  "posX": 143,
                  "posY": 40
                },
                {
                  "emitRate": 117155.016,
                  "idleTime": 10810.6924,
                  "eruptionTime": 85.65657,
                  "dormancyCycles": 54.3534279,
                  "activeCycles": 69.47008,
                  "id": "small_volcano",
                  "posX": 109,
                  "posY": 43
                },
                {
                  "emitRate": 126437.773,
                  "idleTime": 8093.62354,
                  "eruptionTime": 61.1742249,
                  "dormancyCycles": 57.1550179,
                  "activeCycles": 56.5559425,
                  "id": "small_volcano",
                  "posX": 121,
                  "posY": 35
                },
                {
                  "emitRate": 295.495483,
                  "idleTime": 332.62735,
                  "eruptionTime": 492.573639,
                  "dormancyCycles": 94.40097,
                  "activeCycles": 101.218811,
                  "id": "hot_po2",
                  "posX": 75,
                  "posY": 70
                },
                {
                  "emitRate": 315.491028,
                  "idleTime": 165.527557,
                  "eruptionTime": 259.92218,
                  "dormancyCycles": 51.7394867,
                  "activeCycles": 78.9459457,
                  "id": "hot_po2",
                  "posX": 79,
                  "posY": 36
                },
                {
                  "emitRate": 449.487946,
                  "idleTime": 166.98497,
                  "eruptionTime": 204.213516,
                  "dormancyCycles": 51.14357,
                  "activeCycles": 90.82344,
                  "id": "liquid_co2",
                  "posX": 97,
                  "posY": 178
                }
              ]
            },
            {
              "id": "IdealLandingSite",
              "offsetX": 244,
              "offsetY": 0,
              "sizeX": 128,
              "sizeY": 153,
              "worldTraits": [
                "Geodes"
              ],
              "pointsOfInterest": [],
              "geysers": [
                {
                  "emitRate": 9561.395,
                  "idleTime": 232.215363,
                  "eruptionTime": 344.899384,
                  "dormancyCycles": 58.8353043,
                  "activeCycles": 91.5944443,
                  "id": "salt_water",
                  "posX": 279,
                  "posY": 62
                },
                {
                  "emitRate": 486.786346,
                  "idleTime": 254.833435,
                  "eruptionTime": 317.941223,
                  "dormancyCycles": 53.3194122,
                  "activeCycles": 68.4542542,
                  "id": "liquid_co2",
                  "posX": 325,
                  "posY": 33
                },
                {
                  "emitRate": 636.3901,
                  "idleTime": 229.180222,
                  "eruptionTime": 163.837234,
                  "dormancyCycles": 27.4197979,
                  "activeCycles": 63.94983,
                  "id": "liquid_co2",
                  "posX": 312,
                  "posY": 21
                },
                {
                  "emitRate": 7193.40527,
                  "idleTime": 689.0346,
                  "eruptionTime": 49.97238,
                  "dormancyCycles": 33.75622,
                  "activeCycles": 53.454567,
                  "id": "molten_aluminum",
                  "posX": 311,
                  "posY": 50
                },
                {
                  "emitRate": 14701.6807,
                  "idleTime": 754.341736,
                  "eruptionTime": 30.8445663,
                  "dormancyCycles": 44.76565,
                  "activeCycles": 75.6616,
                  "id": "molten_gold",
                  "posX": 267,
                  "posY": 30
                },
                {
                  "emitRate": 7935.261,
                  "idleTime": 780.5782,
                  "eruptionTime": 54.99107,
                  "dormancyCycles": 54.98772,
                  "activeCycles": 90.91191,
                  "id": "molten_gold",
                  "posX": 260,
                  "posY": 48
                },
                {
                  "emitRate": 7911.90137,
                  "idleTime": 797.5543,
                  "eruptionTime": 49.97524,
                  "dormancyCycles": 64.5803146,
                  "activeCycles": 97.04227,
                  "id": "molten_aluminum",
                  "posX": 293,
                  "posY": 39
                },
                {
                  "emitRate": 285.5173,
                  "idleTime": 313.289551,
                  "eruptionTime": 399.02417,
                  "dormancyCycles": 36.374588,
                  "activeCycles": 62.07093,
                  "id": "methane",
                  "posX": 343,
                  "posY": 98
                },
                {
                  "emitRate": 141670.984,
                  "idleTime": 9719.76,
                  "eruptionTime": 75.20136,
                  "dormancyCycles": 45.66538,
                  "activeCycles": 90.43273,
                  "id": "small_volcano",
                  "posX": 355,
                  "posY": 93
                },
                {
                  "emitRate": 7224.45654,
                  "idleTime": 155.223923,
                  "eruptionTime": 266.436157,
                  "dormancyCycles": 63.083683,
                  "activeCycles": 92.84392,
                  "id": "filthy_water",
                  "posX": 328,
                  "posY": 46
                }
              ]
            },
            {
              "id": "WarpOilySwamp",
              "offsetX": 374,
              "offsetY": 0,
              "sizeX": 128,
              "sizeY": 153,
              "worldTraits": [
                "CrashedSatellites",
                "DeepOil"
              ],
              "pointsOfInterest": [
                {
                  "id": "MassiveHeatSink",
                  "posX": 391,
                  "posY": 74
                },
                {
                  "id": "WarpConduitReceiver",
                  "posX": 414,
                  "posY": 89
                },
                {
                  "id": "WarpConduitSender",
                  "posX": 467,
                  "posY": 50
                },
                {
                  "id": "WarpReceiver",
                  "posX": 453,
                  "posY": 68
                },
                {
                  "id": "WarpPortal",
                  "posX": 431,
                  "posY": 68
                }
              ],
              "geysers": [
                {
                  "emitRate": 3919.38843,
                  "idleTime": 211.078827,
                  "eruptionTime": 379.2455,
                  "dormancyCycles": 40.4794769,
                  "activeCycles": 90.03418,
                  "id": "liquid_sulfur",
                  "posX": 433,
                  "posY": 24
                },
                {
                  "emitRate": 3333.33,
                  "idleTime": 0,
                  "eruptionTime": 1,
                  "dormancyCycles": 0,
                  "activeCycles": 1,
                  "id": "OilWell",
                  "posX": 384,
                  "posY": 24
                },
                {
                  "emitRate": 3333.33,
                  "idleTime": 0,
                  "eruptionTime": 1,
                  "dormancyCycles": 0,
                  "activeCycles": 1,
                  "id": "OilWell",
                  "posX": 475,
                  "posY": 25
                },
                {
                  "emitRate": 3333.33,
                  "idleTime": 0,
                  "eruptionTime": 1,
                  "dormancyCycles": 0,
                  "activeCycles": 1,
                  "id": "OilWell",
                  "posX": 406,
                  "posY": 25
                },
                {
                  "emitRate": 3333.33,
                  "idleTime": 0,
                  "eruptionTime": 1,
                  "dormancyCycles": 0,
                  "activeCycles": 1,
                  "id": "OilWell",
                  "posX": 444,
                  "posY": 22
                },
                {
                  "emitRate": 6427.75049,
                  "idleTime": 314.479675,
                  "eruptionTime": 254.258911,
                  "dormancyCycles": 60.0544,
                  "activeCycles": 81.01063,
                  "id": "liquid_sulfur",
                  "posX": 434,
                  "posY": 108
                },
                {
                  "emitRate": 134446.813,
                  "idleTime": 7413.67432,
                  "eruptionTime": 55.82335,
                  "dormancyCycles": 53.80948,
                  "activeCycles": 55.0878372,
                  "id": "small_volcano",
                  "posX": 470,
                  "posY": 98
                },
                {
                  "emitRate": 5957.275,
                  "idleTime": 308.463257,
                  "eruptionTime": 202.5788,
                  "dormancyCycles": 70.05971,
                  "activeCycles": 63.22675,
                  "id": "liquid_sulfur",
                  "posX": 492,
                  "posY": 87
                },
                {
                  "emitRate": 3333.33,
                  "idleTime": 0,
                  "eruptionTime": 1,
                  "dormancyCycles": 0,
                  "activeCycles": 1,
                  "id": "OilWell",
                  "posX": 415,
                  "posY": 33
                },
                {
                  "emitRate": 3333.33,
                  "idleTime": 0,
                  "eruptionTime": 1,
                  "dormancyCycles": 0,
                  "activeCycles": 1,
                  "id": "OilWell",
                  "posX": 404,
                  "posY": 28
                },
                {
                  "emitRate": 3333.33,
                  "idleTime": 0,
                  "eruptionTime": 1,
                  "dormancyCycles": 0,
                  "activeCycles": 1,
                  "id": "OilWell",
                  "posX": 406,
                  "posY": 34
                },
                {
                  "emitRate": 3333.33,
                  "idleTime": 0,
                  "eruptionTime": 1,
                  "dormancyCycles": 0,
                  "activeCycles": 1,
                  "id": "OilWell",
                  "posX": 493,
                  "posY": 28
                },
                {
                  "emitRate": 3333.33,
                  "idleTime": 0,
                  "eruptionTime": 1,
                  "dormancyCycles": 0,
                  "activeCycles": 1,
                  "id": "OilWell",
                  "posX": 489,
                  "posY": 34
                }
              ]
            },
            {
              "id": "TundraMoonlet",
              "offsetX": 162,
              "offsetY": 176,
              "sizeX": 64,
              "sizeY": 128,
              "worldTraits": [
                "SubsurfaceOcean"
              ],
              "pointsOfInterest": [],
              "geysers": [
                {
                  "emitRate": 6709.23145,
                  "idleTime": 767.1997,
                  "eruptionTime": 63.83361,
                  "dormancyCycles": 25.0097618,
                  "activeCycles": 49.79544,
                  "id": "molten_iron",
                  "posX": 212,
                  "posY": 205
                },
                {
                  "emitRate": 13010.5674,
                  "idleTime": 775.070557,
                  "eruptionTime": 28.5491886,
                  "dormancyCycles": 60.5676765,
                  "activeCycles": 77.30743,
                  "id": "molten_iron",
                  "posX": 200,
                  "posY": 220
                },
                {
                  "emitRate": 24355.0547,
                  "idleTime": 746.3921,
                  "eruptionTime": 17.36359,
                  "dormancyCycles": 30.9986725,
                  "activeCycles": 55.502037,
                  "id": "molten_iron",
                  "posX": 208,
                  "posY": 242
                },
                {
                  "emitRate": 8122.66357,
                  "idleTime": 673.0133,
                  "eruptionTime": 42.7235641,
                  "dormancyCycles": 50.1889763,
                  "activeCycles": 73.70502,
                  "id": "molten_iron",
                  "posX": 176,
                  "posY": 229
                }
              ]
            },
            {
              "id": "MarshyMoonlet",
              "offsetX": 228,
              "offsetY": 176,
              "sizeX": 64,
              "sizeY": 96,
              "worldTraits": [
                "MetalPoor"
              ],
              "pointsOfInterest": [
                {
                  "id": "SapTree",
                  "posX": 250,
                  "posY": 230
                },
                {
                  "id": "GeneShuffler",
                  "posX": 244,
                  "posY": 214
                }
              ],
              "geysers": [
                {
                  "emitRate": 9360.264,
                  "idleTime": 617.0439,
                  "eruptionTime": 36.5092049,
                  "dormancyCycles": 53.0014572,
                  "activeCycles": 63.932148,
                  "id": "molten_tungsten",
                  "posX": 261,
                  "posY": 181
                },
                {
                  "emitRate": 13010.5674,
                  "idleTime": 775.070557,
                  "eruptionTime": 28.5491886,
                  "dormancyCycles": 60.5676765,
                  "activeCycles": 77.30743,
                  "id": "molten_tungsten",
                  "posX": 236,
                  "posY": 184
                },
                {
                  "emitRate": 7332.756,
                  "idleTime": 706.153259,
                  "eruptionTime": 55.16449,
                  "dormancyCycles": 57.01898,
                  "activeCycles": 83.37011,
                  "id": "molten_tungsten",
                  "posX": 284,
                  "posY": 183
                },
                {
                  "emitRate": 362.932831,
                  "idleTime": 411.3658,
                  "eruptionTime": 361.681,
                  "dormancyCycles": 54.1676064,
                  "activeCycles": 92.18097,
                  "id": "hot_co2",
                  "posX": 260,
                  "posY": 212
                },
                {
                  "emitRate": 349.205841,
                  "idleTime": 259.956665,
                  "eruptionTime": 211.289932,
                  "dormancyCycles": 50.0450134,
                  "activeCycles": 92.31896,
                  "id": "slimy_po2",
                  "posX": 240,
                  "posY": 199
                }
              ]
            },
            {
              "id": "MooMoonlet",
              "offsetX": 504,
              "offsetY": 0,
              "sizeX": 96,
              "sizeY": 80,
              "worldTraits": [],
              "pointsOfInterest": [],
              "geysers": [
                {
                  "emitRate": 467.163879,
                  "idleTime": 393.691,
                  "eruptionTime": 214.000641,
                  "dormancyCycles": 53.4466858,
                  "activeCycles": 86.65175,
                  "id": "chlorine_gas",
                  "posX": 527,
                  "posY": 29
                }
              ]
            },
            {
              "id": "WaterMoonlet",
              "offsetX": 162,
              "offsetY": 0,
              "sizeX": 80,
              "sizeY": 174,
              "worldTraits": [],
              "pointsOfInterest": [],
              "geysers": [
                {
                  "emitRate": 6359.828,
                  "idleTime": 310.1322,
                  "eruptionTime": 235.3752,
                  "dormancyCycles": 42.8569221,
                  "activeCycles": 87.34086,
                  "id": "slush_water",
                  "posX": 226,
                  "posY": 67
                },
                {
                  "emitRate": 7537.59033,
                  "idleTime": 173.176453,
                  "eruptionTime": 538.668152,
                  "dormancyCycles": 53.8103447,
                  "activeCycles": 72.67059,
                  "id": "filthy_water",
                  "posX": 183,
                  "posY": 91
                }
              ]
            },
            {
              "id": "NiobiumMoonlet",
              "offsetX": 294,
              "offsetY": 155,
              "sizeX": 64,
              "sizeY": 96,
              "worldTraits": [],
              "pointsOfInterest": [],
              "geysers": [
                {
                  "emitRate": 244736,
                  "idleTime": 8829.435,
                  "eruptionTime": 69.2183456,
                  "dormancyCycles": 65.47927,
                  "activeCycles": 86.8800659,
                  "id": "molten_niobium",
                  "posX": 316,
                  "posY": 175
                }
              ]
            },
            {
              "id": "RegolithMoonlet",
              "offsetX": 360,
              "offsetY": 155,
              "sizeX": 160,
              "sizeY": 96,
              "worldTraits": [
                "MetalRich"
              ],
              "pointsOfInterest": [
                {
                  "id": "GeneShuffler",
                  "posX": 395,
                  "posY": 178
                }
              ],
              "geysers": [
                {
                  "emitRate": 1777.29749,
                  "idleTime": 295.769928,
                  "eruptionTime": 518.311768,
                  "dormancyCycles": 39.37839,
                  "activeCycles": 89.0573654,
                  "id": "hot_steam",
                  "posX": 495,
                  "posY": 168
                },
                {
                  "emitRate": 3599.13965,
                  "idleTime": 346.813446,
                  "eruptionTime": 158.768127,
                  "dormancyCycles": 39.8272629,
                  "activeCycles": 67.0544357,
                  "id": "hot_steam",
                  "posX": 427,
                  "posY": 169
                }
              ]
            }
          ],
          "starMapEntriesVanilla": [],
          "starMapEntriesSpacedOut": [
            {
              "q": 0,
              "r": 0,
              "id": "TerraMoonlet"
            },
            {
              "q": -3,
              "r": 0,
              "id": "IdealLandingSite"
            },
            {
              "q": 2,
              "r": -5,
              "id": "WarpOilySwamp"
            },
            {
              "q": 0,
              "r": 7,
              "id": "TundraMoonlet"
            },
            {
              "q": 7,
              "r": -7,
              "id": "MarshyMoonlet"
            },
            {
              "q": 8,
              "r": 0,
              "id": "MooMoonlet"
            },
            {
              "q": -4,
              "r": 6,
              "id": "WaterMoonlet"
            },
            {
              "q": -2,
              "r": -8,
              "id": "NiobiumMoonlet"
            },
            {
              "q": -8,
              "r": 0,
              "id": "RegolithMoonlet"
            },
            {
              "q": 8,
              "r": -5,
              "id": "TemporalTear"
            },
            {
              "q": -2,
              "r": 3,
              "id": "HarvestableSpacePOI_SandyOreField"
            },
            {
              "q": -7,
              "r": 4,
              "id": "HarvestableSpacePOI_OrganicMassField"
            },
            {
              "q": -3,
              "r": 11,
              "id": "HarvestableSpacePOI_HeliumCloud"
            },
            {
              "q": -2,
              "r": 11,
              "id": "HarvestableSpacePOI_FrozenOreField"
            },
            {
              "q": -1,
              "r": 10,
              "id": "HarvestableSpacePOI_GildedAsteroidField"
            },
            {
              "q": -5,
              "r": -3,
              "id": "HarvestableSpacePOI_GlimmeringAsteroidField"
            },
            {
              "q": -7,
              "r": 9,
              "id": "HarvestableSpacePOI_OilyAsteroidField"
            },
            {
              "q": 5,
              "r": -11,
              "id": "HarvestableSpacePOI_RadioactiveAsteroidField"
            },
            {
              "q": 3,
              "r": 8,
              "id": "HarvestableSpacePOI_RadioactiveGasCloud"
            },
            {
              "q": 1,
              "r": -7,
              "id": "HarvestableSpacePOI_InterstellarOcean"
            },
            {
              "q": 3,
              "r": 2,
              "id": "HarvestableSpacePOI_RockyAsteroidField"
            },
            {
              "q": 3,
              "r": 3,
              "id": "HarvestableSpacePOI_RockyAsteroidField"
            },
            {
              "q": -11,
              "r": 1,
              "id": "HarvestableSpacePOI_FrozenOreField"
            },
            {
              "q": -11,
              "r": 0,
              "id": "HarvestableSpacePOI_OxygenRichAsteroidField"
            },
            {
              "q": -11,
              "r": 2,
              "id": "HarvestableSpacePOI_MetallicAsteroidField"
            },
            {
              "q": 11,
              "r": -9,
              "id": "HarvestableSpacePOI_SaltyAsteroidField"
            },
            {
              "q": 6,
              "r": 4,
              "id": "HarvestableSpacePOI_FrozenOreField"
            },
            {
              "q": 10,
              "r": 1,
              "id": "HarvestableSpacePOI_OxidizedAsteroidField"
            },
            {
              "q": 11,
              "r": 0,
              "id": "HarvestableSpacePOI_CarbonAsteroidField"
            },
            {
              "q": 11,
              "r": -1,
              "id": "HarvestableSpacePOI_HeliumCloud"
            },
            {
              "q": 8,
              "r": -10,
              "id": "HarvestableSpacePOI_SatelliteField"
            },
            {
              "q": 1,
              "r": -11,
              "id": "HarvestableSpacePOI_RadioactiveGasCloud"
            },
            {
              "q": 3,
              "r": -3,
              "id": "ArtifactSpacePOI_GravitasSpaceStation6"
            },
            {
              "q": -11,
              "r": 9,
              "id": "ArtifactSpacePOI_RussellsTeapot"
            },
            {
              "q": -1,
              "r": -3,
              "id": "ArtifactSpacePOI_GravitasSpaceStation8"
            }
          ]
        }
      ]
    }
""".trimIndent()

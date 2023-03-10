/*
 * Copyright 2023 The Android Open Source Project
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package ven.petstore.core.domain.model.animal.details

import ven.petstore.core.domain.model.animal.AdoptionStatus
import ven.petstore.core.domain.model.animal.Media
import java.time.LocalDateTime

data class AnimalWithDetails(
        val id: Long,
        val name: String,
        val type: String,
        val details: Details,
        val media: Media,
        val tags: List<String>,
        val adoptionStatus: AdoptionStatus,
        val publishedAt: LocalDateTime
    )
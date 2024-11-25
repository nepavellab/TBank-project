package com.example.tbankapplication.server

import com.example.tbankapplication.data.Joke
import com.google.gson.annotations.SerializedName

data class JokeResponse (
    @SerializedName("error")
    val error: Boolean,
    @SerializedName("amount")
    val amount: Int,
    @SerializedName("jokes")
    val jokes: List<JokeStructure>
)

data class JokeStructure(
    @SerializedName("category")
    val category: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("setup")
    val setup: String,
    @SerializedName("delivery")
    val delivery: String,
    @SerializedName("flags")
    val flags: Flags,
    @SerializedName("id")
    val id: Int,
    @SerializedName("safe")
    val safe: Boolean,
    @SerializedName("lang")
    val lang: String
)

data class Flags(
    @SerializedName("nsfw")
    val nsfw: Boolean,
    @SerializedName("religious")
    val religious: Boolean,
    @SerializedName("political")
    val political: Boolean,
    @SerializedName("racist")
    val racist: Boolean,
    @SerializedName("sexist")
    val sexist: Boolean,
    @SerializedName("explicit")
    val explicit: Boolean
)
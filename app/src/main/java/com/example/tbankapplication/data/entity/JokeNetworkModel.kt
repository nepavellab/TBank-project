package com.example.tbankapplication.data.entity

import com.google.gson.annotations.SerializedName

data class JokeNetworkModel (
    @SerializedName("error")
    val error: Boolean,
    @SerializedName("amount")
    val amount: Int,
    @SerializedName("jokes")
    val jokes: List<JokeListStructure>
)

data class JokeListStructure(
    @SerializedName("category")
    val category: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("setup")
    val question: String,
    @SerializedName("delivery")
    val answer: String,
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
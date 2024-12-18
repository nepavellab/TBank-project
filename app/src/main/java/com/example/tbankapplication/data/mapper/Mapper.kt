package com.example.tbankapplication.data.mapper

import com.example.tbankapplication.data.entity.FavouriteJokeModel
import com.example.tbankapplication.data.entity.JokeListStructure
import com.example.tbankapplication.data.entity.NetworkJokeModel
import com.example.tbankapplication.data.entity.UserJokeModel
import com.example.tbankapplication.domain.entity.Joke
import com.example.tbankapplication.domain.entity.LoadType

object Mapper {
    fun networkResponseToJoke(netResponse: JokeListStructure): Joke {
        with(netResponse) {
            return Joke(
                id = id,
                category = category,
                question = question,
                answer = answer,
                loadType = LoadType.NETWORK,
                isFavourite = false
            )
        }
    }

    fun jokeToUserDBModel(joke: Joke): UserJokeModel {
        with (joke) {
            return UserJokeModel(
                id = id,
                category = category,
                question = question,
                answer = answer,
                loadType = loadType,
                isFavourite = isFavourite
            )
        }
    }

    fun userDBModelToJoke(joke: UserJokeModel): Joke {
        with(joke) {
            return Joke(
                id = id,
                category = category,
                question = question,
                answer = answer,
                loadType = loadType,
                isFavourite = isFavourite
            )
        }
    }

    fun jokeToNetworkDBModel(joke: Joke): NetworkJokeModel {
        with (joke) {
            return NetworkJokeModel(
                id = id,
                category = category,
                question = question,
                answer = answer,
                loadType = loadType,
                isFavourite = isFavourite
            )
        }
    }

    fun networkDBModelToJoke(joke: NetworkJokeModel): Joke {
        with(joke) {
            return Joke(
                id = id,
                category = category,
                question = question,
                answer = answer,
                loadType = loadType,
                isFavourite = isFavourite
            )
        }
    }

    fun jokeToFavouriteDBModel(joke: Joke): FavouriteJokeModel {
        with (joke) {
            return FavouriteJokeModel(
                id = id,
                category = category,
                question = question,
                answer = answer,
                loadType = loadType,
                isFavourite = isFavourite
            )
        }
    }

    fun favouriteDBModelToJoke(joke: FavouriteJokeModel): Joke {
        with(joke) {
            return Joke(
                id = id,
                category = category,
                question = question,
                answer = answer,
                loadType = loadType,
                isFavourite = isFavourite
            )
        }
    }
}
package com.test.domain.model


data class CoinDetailDomainModel(
    val coinId:String,
    val name: String,
    val description: String,
    val symbol:String,
    val rank:Int,
    val isActive:Boolean,
    val tags:List<String>,
    val team:List<TeamMemberDomainModel>
)

data class TeamMemberDomainModel(
    val name: String,
    val id: String,
    val position: String
)
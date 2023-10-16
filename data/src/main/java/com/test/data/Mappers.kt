package com.test.data

import com.test.data.remote.dto.CoinDetailsDto
import com.test.data.remote.dto.CoinDto
import com.test.data.remote.dto.TeamMemberDto
import com.test.domain.model.CoinDetailDomainModel
import com.test.domain.model.CoinDomainModel
import com.test.domain.model.TeamMemberDomainModel

fun CoinDto.toCoinDomain() = CoinDomainModel(
    symbol=symbol,
    isActive=isActive,
    name=name,
    rank=rank,
    id=id
)

fun CoinDetailsDto.toCoinDetailsDomain() = CoinDetailDomainModel(
    coinId = id!!,
    name=name!!,
    description=description!!,
    symbol=symbol!!,
    rank=rank!!,
    isActive=isActive!!,
    tags=tags!!.map { it!!.name!!},
    team=team!!.map { it!!.toTeamMemberDomain() }
)

fun TeamMemberDto.toTeamMemberDomain() = TeamMemberDomainModel(
    name=name!!,
    id=id!!,
    position=position!!
)

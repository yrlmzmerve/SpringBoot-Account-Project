package com.javaspringproject.account.dto

import java.math.BigDecimal
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

data class CreateAccountRequest(
        @field:NotBlank
        var customerId: String,
        @field:Min(0)
        var initialCredit: BigDecimal
)
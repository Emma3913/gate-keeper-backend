package com.gatekeeper.user.infrastructure.exception;

import lombok.Builder;
import java.time.LocalDateTime;

@Builder
public record ApiError(
    String message,
    int status,
    LocalDateTime timestamp
) {}

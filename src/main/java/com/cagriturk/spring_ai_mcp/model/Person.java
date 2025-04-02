package com.cagriturk.spring_ai_mcp.model;

/**
 * Represents a person with basic information.
 * This is an immutable record.
 */
public record Person(
        int id,
        String firstName,
        String lastName,
        String email,
        String sex,
        String ipAddress,
        String jobTitle,
        int age
) {
    // No additional methods needed for a simple record
}
package edu.project3.ParseCMD;

import java.io.BufferedReader;
import java.time.LocalDate;

public record ArgumentsContainer(BufferedReader file, LocalDate from, LocalDate to, OutputFormat outputFormat) {
}

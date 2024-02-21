package test.david.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import test.david.service.FibonacciService;

import java.math.BigInteger;
import java.util.Calendar;

@RestController
@RequestMapping("/")
@Validated
@Slf4j
@Tag(name = "fibonacci", description = "Controller to generate fibonacci")
public class FibonacciController {

    @Autowired
    private FibonacciService fibonacciService;

    /**
     * Calculate fibonacci number for pos 'n'
     *
     * @param n position in fibonacci sequence
     * @return fibonacci number
     */
    @Operation(summary = "Generate fibonacci",
            operationId = "fib",
            description = "Generate fibonacci number",
            tags = {"fibonacci"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "success",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = BigInteger.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid N number", content = @Content)}) // @formatter:on
    @GetMapping("/fib")
    public BigInteger fibonacci(
            @Parameter(description = "Number in the fibonacci sequence to be generated")
            @RequestParam @Min(value = 1, message = "Please send a number greater than 0") Integer n) {

        log.info("Starting: fib={}", n);

        final long time = Calendar.getInstance().getTimeInMillis();

        final BigInteger f = fibonacciService.calculateFibonacci(n);

        final long elapsedTime = Calendar.getInstance().getTimeInMillis() - time;

        log.info("Finishing: fib={}, result={}, elapsedMilliseconds={}", n, f, elapsedTime);

        return f;
    }

}

package br.com.hackathonfc.park.exception;

import br.com.hackathonfc.park.util.ApiError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({
            CnpjFound.class,
            EstacionamentoNotFound.class,
            NomeFound.class,
            PlacaFound.class,
            VeiculoNotFound.class
    })

    @Nullable
    public final ResponseEntity<ApiError> handleException(Exception ex, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();

        LOGGER.error("Lidando com " + ex.getClass().getSimpleName() + " por causa de " + ex.getMessage());

        if (ex instanceof CnpjFound) {
            HttpStatus status = HttpStatus.CONFLICT;
            CnpjFound pnve = (CnpjFound) ex;
            return handleCnpjFound(pnve, headers, status, request);

        } else if (ex instanceof EstacionamentoNotFound) {
            HttpStatus status = HttpStatus.CONFLICT;
            EstacionamentoNotFound anve = (EstacionamentoNotFound) ex;
            return handleEstacionamentoNotFound(anve, headers, status, request);

        } else if (ex instanceof NomeFound) {
            HttpStatus status = HttpStatus.CONFLICT;
            NomeFound efe = (NomeFound) ex;
            return handleNomeFound(efe, headers, status, request);

        } else if (ex instanceof PlacaFound) {
            HttpStatus status = HttpStatus.CONFLICT;
            PlacaFound cpffe = (PlacaFound) ex;
            return handlePlacaFound(cpffe, headers, status, request);

        } if (ex instanceof VeiculoNotFound) {
            HttpStatus status = HttpStatus.CONFLICT;
            VeiculoNotFound cnpjfe = (VeiculoNotFound) ex;
            return handleVeiculoNotFound(cnpjfe, headers, status, request);

        } else {
            if (LOGGER.isWarnEnabled()) {
                LOGGER.warn("Exceção desconhecida: " + ex.getClass().getName());
            }
            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
            return handleExceptionInternal(ex, null, headers, status, request);
        }
    }

    protected final ResponseEntity<ApiError> handleCnpjFound(CnpjFound ex, HttpHeaders headers,
                                                                             HttpStatus status, WebRequest request) {
        String error = ex.getMessage();
        return handleExceptionInternal(ex, new ApiError(error), headers, status, request);
    }

    protected final ResponseEntity<ApiError> handleEstacionamentoNotFound(EstacionamentoNotFound ex, HttpHeaders headers,
                                                                        HttpStatus status, WebRequest request) {
        String error = ex.getMessage();
        return handleExceptionInternal(ex, new ApiError(error), headers, status, request);
    }

    protected final ResponseEntity<ApiError> handleNomeFound(NomeFound ex, HttpHeaders headers,
                                                                       HttpStatus status, WebRequest request) {
        String error = ex.getMessage();
        return handleExceptionInternal(ex, new ApiError(error), headers, status, request);
    }

    protected final ResponseEntity<ApiError> handlePlacaFound(PlacaFound ex, HttpHeaders headers,
                                                                     HttpStatus status, WebRequest request) {
        String error = ex.getMessage();
        return handleExceptionInternal(ex, new ApiError(error), headers, status, request);
    }

    protected final ResponseEntity<ApiError> handleVeiculoNotFound(VeiculoNotFound ex, HttpHeaders headers,
                                                                      HttpStatus status, WebRequest request) {
        String error = ex.getMessage();
        return handleExceptionInternal(ex, new ApiError(error), headers, status, request);
    }

    protected ResponseEntity<ApiError> handleExceptionInternal(Exception ex, @Nullable ApiError body,
                                                               HttpHeaders headers, HttpStatus status,
                                                               WebRequest request) {
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }

        return new ResponseEntity<>(body, headers, status);
    }

}

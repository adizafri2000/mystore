package adi.learn.customerservice.DTO;

import adi.learn.customerservice.util.enums.ResponseEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseResponse<T> {
    /**
     * Response code
     * @see ResponseEnum
     */
    private String responseCode;

    /**
     * Response message
     * @see ResponseEnum
     */
    private String responseMessage;

    private T data;
}

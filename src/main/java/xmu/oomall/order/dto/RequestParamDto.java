package xmu.oomall.order.dto;

import lombok.Data;

import java.util.List;

/**
 * @Author: FY
 * @ModifiedDate: 0:08 2019/12/17
 * @ModifiedBy:
 * @Version:1.0
 */
@Data
public class RequestParamDto {
    private Integer page;
    private Integer limit;
    private Integer orderSn;
    private List<Short> orderStatusArray;
}

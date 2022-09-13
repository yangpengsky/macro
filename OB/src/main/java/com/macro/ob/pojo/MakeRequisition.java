package com.macro.ob.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MakeRequisition {
    private RequisitionInfo requisitionInfo;
    private List<Orders> orders;
}

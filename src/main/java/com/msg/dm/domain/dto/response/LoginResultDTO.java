package com.msg.dm.domain.dto.response;

import com.msg.dm.domain.dto.user.StUserDTO;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Getter @Setter @NoArgsConstructor
public class LoginResultDTO {

    private boolean result;
    private StUserDTO dto;
    private LocalDateTime initTime;


    @Builder
    public LoginResultDTO(boolean result, StUserDTO dto, LocalDateTime now){
        this.result = result;
        this.dto = dto;
        this.initTime = now;
    }

}

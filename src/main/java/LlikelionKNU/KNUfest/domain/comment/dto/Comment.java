package LlikelionKNU.KNUfest.domain.comment.dto;

import LlikelionKNU.KNUfest.domain.booth.entity.BoothEntity;
import LlikelionKNU.KNUfest.domain.comment.entity.CommentEntity;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class Comment {
    private Long id;
    private String name;
    private String comment;
    private String password;
    private Instant created;

    public CommentEntity toEntity(BoothEntity booth){
        return CommentEntity.builder()
                .name(this.name)
                .password(this.password)
                .comment(this.comment)
                .booth(booth)
                .build();
    }
}

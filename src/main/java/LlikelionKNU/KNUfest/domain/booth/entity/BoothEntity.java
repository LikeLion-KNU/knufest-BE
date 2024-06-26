package LlikelionKNU.KNUfest.domain.booth.entity;

import LlikelionKNU.KNUfest.domain.comment.entity.CommentEntity;
import LlikelionKNU.KNUfest.domain.user.entity.UserBoothEntity;
import LlikelionKNU.KNUfest.global.basic.BasicEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "BOOTH")
public class BoothEntity extends BasicEntity {

    @Column(name="booth_name")
    private String boothName;

    @Column(name="likes")
    @ColumnDefault("0")
    private int likes;

    @Column(name="categori")
    private String categori;

    @Column(name="booth_num")
    private int boothnum;

    @Column(name="description")
    private String description;

    @Column(name="host")
    private String host;

    @Column(name="commentCount")
    @ColumnDefault("0")
    private int commentCount;

    @OneToMany(mappedBy = "booth", fetch = FetchType.LAZY)
    private List<CommentEntity> commentEntityList;

    @OneToMany(mappedBy = "booth", fetch = FetchType.LAZY)
    private List<UserBoothEntity> userBoothEntity;

    @ElementCollection
    @CollectionTable(
            name = "URL_LIST",
            joinColumns = @JoinColumn(name="booth_id", referencedColumnName = "id")
    )
    @Column(columnDefinition = "VARCHAR(300)")
    private List<String> urls;
}

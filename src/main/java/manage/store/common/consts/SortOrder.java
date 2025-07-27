package manage.store.common.consts;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SortOrder {

    private Long sortOrder;

    public SortOrder(Long sortOrder) {
        if(!isValidSortOrder(sortOrder))
            throw new IllegalArgumentException("Sort order must be a non-negative integer. Provided: " + sortOrder);

        this.sortOrder = sortOrder;
    }

    private boolean isValidSortOrder(Long sortOrder) {
        return sortOrder != null && sortOrder >= 0;
    }

}

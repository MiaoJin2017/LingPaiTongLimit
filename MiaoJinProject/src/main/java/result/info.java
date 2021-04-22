package result;

import lombok.Data;

@Data
public class info {
    private int code;
    private String msg;

    public static info SUCCESS = new info(0, "成功");
    public static info ACQUIRE_SUCCESS = new info(200001, "已成功!");
    public static info UNKNOWN_LIMITER = new info(500001, "限制!");
    public static info ACQUIRE_LIMITED = new info(500002, "限制被拒绝!");

    private info(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

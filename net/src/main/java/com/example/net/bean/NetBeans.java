package com.example.net.bean;

import java.util.List;

public class NetBeans {

    /**
     * data : {"status":10,"user_id":"toutiao","video_id":"v020042b0000c09ea96g08jpk36nldrg","key_seed":"","validate":"","enable_ssl":true,"enable_adaptive":true,"poster_url":"http://p3-tt.bytecdn.cn/obj/tos-cn-p-0015/84effc92b64f45588cb44ba5d20344ac","big_thumbs":[{"img_num":22,"uri":"36d30000e9b4731d4c042","img_url":"http://p3-tt.bytecdn.cn/origin/36d30000e9b4731d4c042","img_urls":["http://p3-tt.bytecdn.cn/origin/36d30000e9b4731d4c042"],"img_x_size":240,"img_y_size":136,"img_x_len":10,"img_y_len":3,"duration":21.480333,"interval":1,"fext":"jpg"}],"video_duration":21.534,"media_type":"video","auto_definition":"360p","video_list":{"video_1":{"definition":"360p","vtype":"mp4","vwidth":640,"vheight":360,"bitrate":323054,"size":869583,"quality":"normal","codec_type":"h264","logo_type":"xigua","encrypt":false,"file_hash":"ae156d3d803c4cb2cedfbc8f5243acce","file_id":"c73178ac3ccb4e4bb28243f0bb582e0e","main_url":"aHR0cDovL3YzLWRlZmF1bHQuaXhpZ3VhLmNvbS9kMDIzZWQwMzU3ZmZiNjE0ZDZkOTExY2I5YjY0Nzg3ZC82MDE0MDNhMi92aWRlby90b3MvY24vdG9zLWNuLXZlLTQvMmJmODdhYjI1NDk1NDMxMWI2ZjM3N2JmYzYxYjIyY2MvP2E9MjAxMiZicj05NDUmYnQ9MzE1JmNkPTAlN0MwJTdDMCZjaD0wJmNyPTAmY3M9MCZkcj0wJmRzPTEmZXI9Jmw9MjAyMTAxMjkxOTQ2MDUwMTAwMTAwMzUwMjEwNDAzRTEwQyZscj0mbWltZV90eXBlPXZpZGVvX21wNCZwbD0wJnFzPTAmcmM9YW1keE5uTTdhanhvTXpNelpUY3pNMEFwTXpVNFpXazNPMlUzTjJZMlpEbzJabWR2YVROb1p5MHpYalpnTFMwdkxTOXpjMkppTlY4dE1DOHZYMkpmWUdBMUxqUTZZdyUzRCUzRCZ2bD0mdnI9","backup_url_1":"aHR0cDovL3Y2LWRlZmF1bHQuaXhpZ3VhLmNvbS80ZDI0NDkyNjBjMTE3NGQwMzRiYWFhM2Y0ZDQ0NzlkNC82MDE0MDNhMi92aWRlby90b3MvY24vdG9zLWNuLXZlLTQvMmJmODdhYjI1NDk1NDMxMWI2ZjM3N2JmYzYxYjIyY2MvP2E9MjAxMiZicj05NDUmYnQ9MzE1JmNkPTAlN0MwJTdDMCZjaD0wJmNyPTAmY3M9MCZkcj0wJmRzPTEmZXI9Jmw9MjAyMTAxMjkxOTQ2MDUwMTAwMTAwMzUwMjEwNDAzRTEwQyZscj0mbWltZV90eXBlPXZpZGVvX21wNCZwbD0wJnFzPTAmcmM9YW1keE5uTTdhanhvTXpNelpUY3pNMEFwTXpVNFpXazNPMlUzTjJZMlpEbzJabWR2YVROb1p5MHpYalpnTFMwdkxTOXpjMkppTlY4dE1DOHZYMkpmWUdBMUxqUTZZdyUzRCUzRCZ2bD0mdnI9","check_info":"c:0-24853-58d9|d:0-434790-f598,434791-869582-effc","p2p_verify_url":"aHR0cDovL3YzLWRlZmF1bHQuaXhpZ3VhLmNvbS81ZDBhYWNjZDI4NWU5YzQzNzQ0ZjE5YjEyMDMwMmMwNy82MDE0MDNhMi92aWRlby90b3MvY24vdG9zLWNuLXZlLTQvODUyNDY5NjhiMDlmNGRiNjkzMGQ2YjQyMDQxMTY4OWUv","user_video_proxy":1,"socket_buffer":7268580,"preload_size":327680,"preload_interval":60,"preload_min_step":5,"preload_max_step":10,"spade_a":"","kid":"","barrage_mask_url":"","barrage_mask_offset":""},"video_2":{"definition":"480p","vtype":"mp4","vwidth":854,"vheight":480,"bitrate":467023,"size":1257111,"quality":"normal","codec_type":"h264","logo_type":"xigua","encrypt":false,"file_hash":"d408d4f85ce8dc2bc9ecaaa6c94128ac","file_id":"a279b1d3d41547eb85f98bb2c2dec0fb","main_url":"aHR0cDovL3YzLWRlZmF1bHQuaXhpZ3VhLmNvbS9kMzI2ZGUyMWVmODIxY2E0ZjgxOTE5MzhlZjFlNTAzZC82MDE0MDNhMi92aWRlby90b3MvY24vdG9zLWNuLXZlLTQvNTRhOTZmNGEyMTZiNGEzOWEzYTcxODA2ODM1MDg0NDQvP2E9MjAxMiZicj0xMzY4JmJ0PTQ1NiZjZD0wJTdDMCU3QzAmY2g9MCZjcj0wJmNzPTAmZHI9MCZkcz0yJmVyPSZsPTIwMjEwMTI5MTk0NjA1MDEwMDEwMDM1MDIxMDQwM0UxMEMmbHI9Jm1pbWVfdHlwZT12aWRlb19tcDQmcGw9MCZxcz0wJnJjPWFtZHhObk03YWp4b016TXpaVGN6TTBBcGFXWm5abVU3YVR0b056Um5aMlU2WkdkdmFUTm9aeTB6WGpaZ0xTMHZMUzl6YzE4dFlpOHZYell5WHpReU1UQXVOaTg2WXclM0QlM0Qmdmw9JnZyPQ==","backup_url_1":"aHR0cDovL3Y2LWRlZmF1bHQuaXhpZ3VhLmNvbS8xNjRlOGFjM2Q2YTBiNWY0YjdjMzkyNWU2ZWU2ZGYwNy82MDE0MDNhMi92aWRlby90b3MvY24vdG9zLWNuLXZlLTQvNTRhOTZmNGEyMTZiNGEzOWEzYTcxODA2ODM1MDg0NDQvP2E9MjAxMiZicj0xMzY4JmJ0PTQ1NiZjZD0wJTdDMCU3QzAmY2g9MCZjcj0wJmNzPTAmZHI9MCZkcz0yJmVyPSZsPTIwMjEwMTI5MTk0NjA1MDEwMDEwMDM1MDIxMDQwM0UxMEMmbHI9Jm1pbWVfdHlwZT12aWRlb19tcDQmcGw9MCZxcz0wJnJjPWFtZHhObk03YWp4b016TXpaVGN6TTBBcGFXWm5abVU3YVR0b056Um5aMlU2WkdkdmFUTm9aeTB6WGpaZ0xTMHZMUzl6YzE4dFlpOHZYell5WHpReU1UQXVOaTg2WXclM0QlM0Qmdmw9JnZyPQ==","check_info":"c:0-24637-b7a8|d:0-628554-d734,628555-1257110-a51c","p2p_verify_url":"aHR0cDovL3YzLWRlZmF1bHQuaXhpZ3VhLmNvbS82MjllYWZjNmIyNzNiMmI0NmQxY2E4ZmMzOTU5Yzg2Yi82MDE0MDNhMi92aWRlby90b3MvY24vdG9zLWNuLXZlLTQvOWU3MDk0MjNmZTFmNDgzOWEwYjQ3NTIwMDdlYTBiOWUv","user_video_proxy":1,"socket_buffer":10507860,"preload_size":327680,"preload_interval":60,"preload_min_step":5,"preload_max_step":10,"spade_a":"","kid":"","barrage_mask_url":"","barrage_mask_offset":""},"video_3":{"definition":"720p","vtype":"mp4","vwidth":1280,"vheight":720,"bitrate":1168461,"size":3145207,"quality":"normal","codec_type":"h264","logo_type":"xigua","encrypt":false,"file_hash":"6db22a5acfa49cad9843d95aa18b3f98","file_id":"82f8f97dfa49436ca77f52e5773dc64e","main_url":"aHR0cDovL3YzLWRlZmF1bHQuaXhpZ3VhLmNvbS9kZDAzNTRlOWZhMjE3MWY5ZmYyYzJlMjI3YzRjMjg3OS82MDE0MDNhMi92aWRlby90b3MvY24vdG9zLWNuLXZlLTQvNmJjMjUzZDJhMjUzNDY2NTlmZDYzMDQ4ZmRmYjE4ZjIvP2E9MjAxMiZicj0zNDIzJmJ0PTExNDEmY2Q9MCU3QzAlN0MwJmNoPTAmY3I9MCZjcz0wJmRyPTAmZHM9MyZlcj0mbD0yMDIxMDEyOTE5NDYwNTAxMDAxMDAzNTAyMTA0MDNFMTBDJmxyPSZtaW1lX3R5cGU9dmlkZW9fbXA0JnBsPTAmcXM9MCZyYz1hbWR4Tm5NN2FqeG9Nek16WlRjek0wQXBOMlkyT21nNE9tUTVOemRwT21scE8yZHZhVE5vWnkwelhqWmdMUzB2TFM5emMySXpZVFF5TDJNMFlEQTJYbUUyTlM4Nll3JTNEJTNEJnZsPSZ2cj0=","backup_url_1":"aHR0cDovL3Y2LWRlZmF1bHQuaXhpZ3VhLmNvbS9jYTY4NmViMWM1OGM5MWQ0ZGM1ZTU5YTczNDc5YTNiNC82MDE0MDNhMi92aWRlby90b3MvY24vdG9zLWNuLXZlLTQvNmJjMjUzZDJhMjUzNDY2NTlmZDYzMDQ4ZmRmYjE4ZjIvP2E9MjAxMiZicj0zNDIzJmJ0PTExNDEmY2Q9MCU3QzAlN0MwJmNoPTAmY3I9MCZjcz0wJmRyPTAmZHM9MyZlcj0mbD0yMDIxMDEyOTE5NDYwNTAxMDAxMDAzNTAyMTA0MDNFMTBDJmxyPSZtaW1lX3R5cGU9dmlkZW9fbXA0JnBsPTAmcXM9MCZyYz1hbWR4Tm5NN2FqeG9Nek16WlRjek0wQXBOMlkyT21nNE9tUTVOemRwT21scE8yZHZhVE5vWnkwelhqWmdMUzB2TFM5emMySXpZVFF5TDJNMFlEQTJYbUUyTlM4Nll3JTNEJTNEJnZsPSZ2cj0=","check_info":"c:0-24106-5546|d:0-1572602-e256,1572603-3145206-eac5","p2p_verify_url":"aHR0cDovL3YzLWRlZmF1bHQuaXhpZ3VhLmNvbS8wODk0NGNiNzg0NDBhNjRkMDBlNDJlODAyOTY4MDlkMC82MDE0MDNhMi92aWRlby90b3MvY24vdG9zLWNuLXZlLTQvY2MzMmYxZjY4YWEzNDZjZGFkM2U5YWMwMDA1MmY4ZGUv","user_video_proxy":1,"socket_buffer":26290260,"preload_size":327680,"preload_interval":60,"preload_min_step":5,"preload_max_step":10,"spade_a":"","kid":"","barrage_mask_url":"","barrage_mask_offset":""}},"dynamic_video":null,"dns_info":null,"optimal_decoding_mode":"","subtitle_langs":null}
     * message : success
     * code : 0
     * total : 3
     */

    private DataBean data;
    private String message;
    private int code;
    private int total;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public static class DataBean {
        /**
         * status : 10
         * user_id : toutiao
         * video_id : v020042b0000c09ea96g08jpk36nldrg
         * key_seed :
         * validate :
         * enable_ssl : true
         * enable_adaptive : true
         * poster_url : http://p3-tt.bytecdn.cn/obj/tos-cn-p-0015/84effc92b64f45588cb44ba5d20344ac
         * big_thumbs : [{"img_num":22,"uri":"36d30000e9b4731d4c042","img_url":"http://p3-tt.bytecdn.cn/origin/36d30000e9b4731d4c042","img_urls":["http://p3-tt.bytecdn.cn/origin/36d30000e9b4731d4c042"],"img_x_size":240,"img_y_size":136,"img_x_len":10,"img_y_len":3,"duration":21.480333,"interval":1,"fext":"jpg"}]
         * video_duration : 21.534
         * media_type : video
         * auto_definition : 360p
         * video_list : {"video_1":{"definition":"360p","vtype":"mp4","vwidth":640,"vheight":360,"bitrate":323054,"size":869583,"quality":"normal","codec_type":"h264","logo_type":"xigua","encrypt":false,"file_hash":"ae156d3d803c4cb2cedfbc8f5243acce","file_id":"c73178ac3ccb4e4bb28243f0bb582e0e","main_url":"aHR0cDovL3YzLWRlZmF1bHQuaXhpZ3VhLmNvbS9kMDIzZWQwMzU3ZmZiNjE0ZDZkOTExY2I5YjY0Nzg3ZC82MDE0MDNhMi92aWRlby90b3MvY24vdG9zLWNuLXZlLTQvMmJmODdhYjI1NDk1NDMxMWI2ZjM3N2JmYzYxYjIyY2MvP2E9MjAxMiZicj05NDUmYnQ9MzE1JmNkPTAlN0MwJTdDMCZjaD0wJmNyPTAmY3M9MCZkcj0wJmRzPTEmZXI9Jmw9MjAyMTAxMjkxOTQ2MDUwMTAwMTAwMzUwMjEwNDAzRTEwQyZscj0mbWltZV90eXBlPXZpZGVvX21wNCZwbD0wJnFzPTAmcmM9YW1keE5uTTdhanhvTXpNelpUY3pNMEFwTXpVNFpXazNPMlUzTjJZMlpEbzJabWR2YVROb1p5MHpYalpnTFMwdkxTOXpjMkppTlY4dE1DOHZYMkpmWUdBMUxqUTZZdyUzRCUzRCZ2bD0mdnI9","backup_url_1":"aHR0cDovL3Y2LWRlZmF1bHQuaXhpZ3VhLmNvbS80ZDI0NDkyNjBjMTE3NGQwMzRiYWFhM2Y0ZDQ0NzlkNC82MDE0MDNhMi92aWRlby90b3MvY24vdG9zLWNuLXZlLTQvMmJmODdhYjI1NDk1NDMxMWI2ZjM3N2JmYzYxYjIyY2MvP2E9MjAxMiZicj05NDUmYnQ9MzE1JmNkPTAlN0MwJTdDMCZjaD0wJmNyPTAmY3M9MCZkcj0wJmRzPTEmZXI9Jmw9MjAyMTAxMjkxOTQ2MDUwMTAwMTAwMzUwMjEwNDAzRTEwQyZscj0mbWltZV90eXBlPXZpZGVvX21wNCZwbD0wJnFzPTAmcmM9YW1keE5uTTdhanhvTXpNelpUY3pNMEFwTXpVNFpXazNPMlUzTjJZMlpEbzJabWR2YVROb1p5MHpYalpnTFMwdkxTOXpjMkppTlY4dE1DOHZYMkpmWUdBMUxqUTZZdyUzRCUzRCZ2bD0mdnI9","check_info":"c:0-24853-58d9|d:0-434790-f598,434791-869582-effc","p2p_verify_url":"aHR0cDovL3YzLWRlZmF1bHQuaXhpZ3VhLmNvbS81ZDBhYWNjZDI4NWU5YzQzNzQ0ZjE5YjEyMDMwMmMwNy82MDE0MDNhMi92aWRlby90b3MvY24vdG9zLWNuLXZlLTQvODUyNDY5NjhiMDlmNGRiNjkzMGQ2YjQyMDQxMTY4OWUv","user_video_proxy":1,"socket_buffer":7268580,"preload_size":327680,"preload_interval":60,"preload_min_step":5,"preload_max_step":10,"spade_a":"","kid":"","barrage_mask_url":"","barrage_mask_offset":""},"video_2":{"definition":"480p","vtype":"mp4","vwidth":854,"vheight":480,"bitrate":467023,"size":1257111,"quality":"normal","codec_type":"h264","logo_type":"xigua","encrypt":false,"file_hash":"d408d4f85ce8dc2bc9ecaaa6c94128ac","file_id":"a279b1d3d41547eb85f98bb2c2dec0fb","main_url":"aHR0cDovL3YzLWRlZmF1bHQuaXhpZ3VhLmNvbS9kMzI2ZGUyMWVmODIxY2E0ZjgxOTE5MzhlZjFlNTAzZC82MDE0MDNhMi92aWRlby90b3MvY24vdG9zLWNuLXZlLTQvNTRhOTZmNGEyMTZiNGEzOWEzYTcxODA2ODM1MDg0NDQvP2E9MjAxMiZicj0xMzY4JmJ0PTQ1NiZjZD0wJTdDMCU3QzAmY2g9MCZjcj0wJmNzPTAmZHI9MCZkcz0yJmVyPSZsPTIwMjEwMTI5MTk0NjA1MDEwMDEwMDM1MDIxMDQwM0UxMEMmbHI9Jm1pbWVfdHlwZT12aWRlb19tcDQmcGw9MCZxcz0wJnJjPWFtZHhObk03YWp4b016TXpaVGN6TTBBcGFXWm5abVU3YVR0b056Um5aMlU2WkdkdmFUTm9aeTB6WGpaZ0xTMHZMUzl6YzE4dFlpOHZYell5WHpReU1UQXVOaTg2WXclM0QlM0Qmdmw9JnZyPQ==","backup_url_1":"aHR0cDovL3Y2LWRlZmF1bHQuaXhpZ3VhLmNvbS8xNjRlOGFjM2Q2YTBiNWY0YjdjMzkyNWU2ZWU2ZGYwNy82MDE0MDNhMi92aWRlby90b3MvY24vdG9zLWNuLXZlLTQvNTRhOTZmNGEyMTZiNGEzOWEzYTcxODA2ODM1MDg0NDQvP2E9MjAxMiZicj0xMzY4JmJ0PTQ1NiZjZD0wJTdDMCU3QzAmY2g9MCZjcj0wJmNzPTAmZHI9MCZkcz0yJmVyPSZsPTIwMjEwMTI5MTk0NjA1MDEwMDEwMDM1MDIxMDQwM0UxMEMmbHI9Jm1pbWVfdHlwZT12aWRlb19tcDQmcGw9MCZxcz0wJnJjPWFtZHhObk03YWp4b016TXpaVGN6TTBBcGFXWm5abVU3YVR0b056Um5aMlU2WkdkdmFUTm9aeTB6WGpaZ0xTMHZMUzl6YzE4dFlpOHZYell5WHpReU1UQXVOaTg2WXclM0QlM0Qmdmw9JnZyPQ==","check_info":"c:0-24637-b7a8|d:0-628554-d734,628555-1257110-a51c","p2p_verify_url":"aHR0cDovL3YzLWRlZmF1bHQuaXhpZ3VhLmNvbS82MjllYWZjNmIyNzNiMmI0NmQxY2E4ZmMzOTU5Yzg2Yi82MDE0MDNhMi92aWRlby90b3MvY24vdG9zLWNuLXZlLTQvOWU3MDk0MjNmZTFmNDgzOWEwYjQ3NTIwMDdlYTBiOWUv","user_video_proxy":1,"socket_buffer":10507860,"preload_size":327680,"preload_interval":60,"preload_min_step":5,"preload_max_step":10,"spade_a":"","kid":"","barrage_mask_url":"","barrage_mask_offset":""},"video_3":{"definition":"720p","vtype":"mp4","vwidth":1280,"vheight":720,"bitrate":1168461,"size":3145207,"quality":"normal","codec_type":"h264","logo_type":"xigua","encrypt":false,"file_hash":"6db22a5acfa49cad9843d95aa18b3f98","file_id":"82f8f97dfa49436ca77f52e5773dc64e","main_url":"aHR0cDovL3YzLWRlZmF1bHQuaXhpZ3VhLmNvbS9kZDAzNTRlOWZhMjE3MWY5ZmYyYzJlMjI3YzRjMjg3OS82MDE0MDNhMi92aWRlby90b3MvY24vdG9zLWNuLXZlLTQvNmJjMjUzZDJhMjUzNDY2NTlmZDYzMDQ4ZmRmYjE4ZjIvP2E9MjAxMiZicj0zNDIzJmJ0PTExNDEmY2Q9MCU3QzAlN0MwJmNoPTAmY3I9MCZjcz0wJmRyPTAmZHM9MyZlcj0mbD0yMDIxMDEyOTE5NDYwNTAxMDAxMDAzNTAyMTA0MDNFMTBDJmxyPSZtaW1lX3R5cGU9dmlkZW9fbXA0JnBsPTAmcXM9MCZyYz1hbWR4Tm5NN2FqeG9Nek16WlRjek0wQXBOMlkyT21nNE9tUTVOemRwT21scE8yZHZhVE5vWnkwelhqWmdMUzB2TFM5emMySXpZVFF5TDJNMFlEQTJYbUUyTlM4Nll3JTNEJTNEJnZsPSZ2cj0=","backup_url_1":"aHR0cDovL3Y2LWRlZmF1bHQuaXhpZ3VhLmNvbS9jYTY4NmViMWM1OGM5MWQ0ZGM1ZTU5YTczNDc5YTNiNC82MDE0MDNhMi92aWRlby90b3MvY24vdG9zLWNuLXZlLTQvNmJjMjUzZDJhMjUzNDY2NTlmZDYzMDQ4ZmRmYjE4ZjIvP2E9MjAxMiZicj0zNDIzJmJ0PTExNDEmY2Q9MCU3QzAlN0MwJmNoPTAmY3I9MCZjcz0wJmRyPTAmZHM9MyZlcj0mbD0yMDIxMDEyOTE5NDYwNTAxMDAxMDAzNTAyMTA0MDNFMTBDJmxyPSZtaW1lX3R5cGU9dmlkZW9fbXA0JnBsPTAmcXM9MCZyYz1hbWR4Tm5NN2FqeG9Nek16WlRjek0wQXBOMlkyT21nNE9tUTVOemRwT21scE8yZHZhVE5vWnkwelhqWmdMUzB2TFM5emMySXpZVFF5TDJNMFlEQTJYbUUyTlM4Nll3JTNEJTNEJnZsPSZ2cj0=","check_info":"c:0-24106-5546|d:0-1572602-e256,1572603-3145206-eac5","p2p_verify_url":"aHR0cDovL3YzLWRlZmF1bHQuaXhpZ3VhLmNvbS8wODk0NGNiNzg0NDBhNjRkMDBlNDJlODAyOTY4MDlkMC82MDE0MDNhMi92aWRlby90b3MvY24vdG9zLWNuLXZlLTQvY2MzMmYxZjY4YWEzNDZjZGFkM2U5YWMwMDA1MmY4ZGUv","user_video_proxy":1,"socket_buffer":26290260,"preload_size":327680,"preload_interval":60,"preload_min_step":5,"preload_max_step":10,"spade_a":"","kid":"","barrage_mask_url":"","barrage_mask_offset":""}}
         * dynamic_video : null
         * dns_info : null
         * optimal_decoding_mode :
         * subtitle_langs : null
         */

        private int status;
        private String user_id;
        private String video_id;
        private String key_seed;
        private String validate;
        private boolean enable_ssl;
        private boolean enable_adaptive;
        private String poster_url;
        private double video_duration;
        private String media_type;
        private String auto_definition;
        private VideoListBean video_list;
        private Object dynamic_video;
        private Object dns_info;
        private String optimal_decoding_mode;
        private Object subtitle_langs;
        private List<BigThumbsBean> big_thumbs;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getVideo_id() {
            return video_id;
        }

        public void setVideo_id(String video_id) {
            this.video_id = video_id;
        }

        public String getKey_seed() {
            return key_seed;
        }

        public void setKey_seed(String key_seed) {
            this.key_seed = key_seed;
        }

        public String getValidate() {
            return validate;
        }

        public void setValidate(String validate) {
            this.validate = validate;
        }

        public boolean isEnable_ssl() {
            return enable_ssl;
        }

        public void setEnable_ssl(boolean enable_ssl) {
            this.enable_ssl = enable_ssl;
        }

        public boolean isEnable_adaptive() {
            return enable_adaptive;
        }

        public void setEnable_adaptive(boolean enable_adaptive) {
            this.enable_adaptive = enable_adaptive;
        }

        public String getPoster_url() {
            return poster_url;
        }

        public void setPoster_url(String poster_url) {
            this.poster_url = poster_url;
        }

        public double getVideo_duration() {
            return video_duration;
        }

        public void setVideo_duration(double video_duration) {
            this.video_duration = video_duration;
        }

        public String getMedia_type() {
            return media_type;
        }

        public void setMedia_type(String media_type) {
            this.media_type = media_type;
        }

        public String getAuto_definition() {
            return auto_definition;
        }

        public void setAuto_definition(String auto_definition) {
            this.auto_definition = auto_definition;
        }

        public VideoListBean getVideo_list() {
            return video_list;
        }

        public void setVideo_list(VideoListBean video_list) {
            this.video_list = video_list;
        }

        public Object getDynamic_video() {
            return dynamic_video;
        }

        public void setDynamic_video(Object dynamic_video) {
            this.dynamic_video = dynamic_video;
        }

        public Object getDns_info() {
            return dns_info;
        }

        public void setDns_info(Object dns_info) {
            this.dns_info = dns_info;
        }

        public String getOptimal_decoding_mode() {
            return optimal_decoding_mode;
        }

        public void setOptimal_decoding_mode(String optimal_decoding_mode) {
            this.optimal_decoding_mode = optimal_decoding_mode;
        }

        public Object getSubtitle_langs() {
            return subtitle_langs;
        }

        public void setSubtitle_langs(Object subtitle_langs) {
            this.subtitle_langs = subtitle_langs;
        }

        public List<BigThumbsBean> getBig_thumbs() {
            return big_thumbs;
        }

        public void setBig_thumbs(List<BigThumbsBean> big_thumbs) {
            this.big_thumbs = big_thumbs;
        }

        public static class VideoListBean {
            /**
             * video_1 : {"definition":"360p","vtype":"mp4","vwidth":640,"vheight":360,"bitrate":323054,"size":869583,"quality":"normal","codec_type":"h264","logo_type":"xigua","encrypt":false,"file_hash":"ae156d3d803c4cb2cedfbc8f5243acce","file_id":"c73178ac3ccb4e4bb28243f0bb582e0e","main_url":"aHR0cDovL3YzLWRlZmF1bHQuaXhpZ3VhLmNvbS9kMDIzZWQwMzU3ZmZiNjE0ZDZkOTExY2I5YjY0Nzg3ZC82MDE0MDNhMi92aWRlby90b3MvY24vdG9zLWNuLXZlLTQvMmJmODdhYjI1NDk1NDMxMWI2ZjM3N2JmYzYxYjIyY2MvP2E9MjAxMiZicj05NDUmYnQ9MzE1JmNkPTAlN0MwJTdDMCZjaD0wJmNyPTAmY3M9MCZkcj0wJmRzPTEmZXI9Jmw9MjAyMTAxMjkxOTQ2MDUwMTAwMTAwMzUwMjEwNDAzRTEwQyZscj0mbWltZV90eXBlPXZpZGVvX21wNCZwbD0wJnFzPTAmcmM9YW1keE5uTTdhanhvTXpNelpUY3pNMEFwTXpVNFpXazNPMlUzTjJZMlpEbzJabWR2YVROb1p5MHpYalpnTFMwdkxTOXpjMkppTlY4dE1DOHZYMkpmWUdBMUxqUTZZdyUzRCUzRCZ2bD0mdnI9","backup_url_1":"aHR0cDovL3Y2LWRlZmF1bHQuaXhpZ3VhLmNvbS80ZDI0NDkyNjBjMTE3NGQwMzRiYWFhM2Y0ZDQ0NzlkNC82MDE0MDNhMi92aWRlby90b3MvY24vdG9zLWNuLXZlLTQvMmJmODdhYjI1NDk1NDMxMWI2ZjM3N2JmYzYxYjIyY2MvP2E9MjAxMiZicj05NDUmYnQ9MzE1JmNkPTAlN0MwJTdDMCZjaD0wJmNyPTAmY3M9MCZkcj0wJmRzPTEmZXI9Jmw9MjAyMTAxMjkxOTQ2MDUwMTAwMTAwMzUwMjEwNDAzRTEwQyZscj0mbWltZV90eXBlPXZpZGVvX21wNCZwbD0wJnFzPTAmcmM9YW1keE5uTTdhanhvTXpNelpUY3pNMEFwTXpVNFpXazNPMlUzTjJZMlpEbzJabWR2YVROb1p5MHpYalpnTFMwdkxTOXpjMkppTlY4dE1DOHZYMkpmWUdBMUxqUTZZdyUzRCUzRCZ2bD0mdnI9","check_info":"c:0-24853-58d9|d:0-434790-f598,434791-869582-effc","p2p_verify_url":"aHR0cDovL3YzLWRlZmF1bHQuaXhpZ3VhLmNvbS81ZDBhYWNjZDI4NWU5YzQzNzQ0ZjE5YjEyMDMwMmMwNy82MDE0MDNhMi92aWRlby90b3MvY24vdG9zLWNuLXZlLTQvODUyNDY5NjhiMDlmNGRiNjkzMGQ2YjQyMDQxMTY4OWUv","user_video_proxy":1,"socket_buffer":7268580,"preload_size":327680,"preload_interval":60,"preload_min_step":5,"preload_max_step":10,"spade_a":"","kid":"","barrage_mask_url":"","barrage_mask_offset":""}
             * video_2 : {"definition":"480p","vtype":"mp4","vwidth":854,"vheight":480,"bitrate":467023,"size":1257111,"quality":"normal","codec_type":"h264","logo_type":"xigua","encrypt":false,"file_hash":"d408d4f85ce8dc2bc9ecaaa6c94128ac","file_id":"a279b1d3d41547eb85f98bb2c2dec0fb","main_url":"aHR0cDovL3YzLWRlZmF1bHQuaXhpZ3VhLmNvbS9kMzI2ZGUyMWVmODIxY2E0ZjgxOTE5MzhlZjFlNTAzZC82MDE0MDNhMi92aWRlby90b3MvY24vdG9zLWNuLXZlLTQvNTRhOTZmNGEyMTZiNGEzOWEzYTcxODA2ODM1MDg0NDQvP2E9MjAxMiZicj0xMzY4JmJ0PTQ1NiZjZD0wJTdDMCU3QzAmY2g9MCZjcj0wJmNzPTAmZHI9MCZkcz0yJmVyPSZsPTIwMjEwMTI5MTk0NjA1MDEwMDEwMDM1MDIxMDQwM0UxMEMmbHI9Jm1pbWVfdHlwZT12aWRlb19tcDQmcGw9MCZxcz0wJnJjPWFtZHhObk03YWp4b016TXpaVGN6TTBBcGFXWm5abVU3YVR0b056Um5aMlU2WkdkdmFUTm9aeTB6WGpaZ0xTMHZMUzl6YzE4dFlpOHZYell5WHpReU1UQXVOaTg2WXclM0QlM0Qmdmw9JnZyPQ==","backup_url_1":"aHR0cDovL3Y2LWRlZmF1bHQuaXhpZ3VhLmNvbS8xNjRlOGFjM2Q2YTBiNWY0YjdjMzkyNWU2ZWU2ZGYwNy82MDE0MDNhMi92aWRlby90b3MvY24vdG9zLWNuLXZlLTQvNTRhOTZmNGEyMTZiNGEzOWEzYTcxODA2ODM1MDg0NDQvP2E9MjAxMiZicj0xMzY4JmJ0PTQ1NiZjZD0wJTdDMCU3QzAmY2g9MCZjcj0wJmNzPTAmZHI9MCZkcz0yJmVyPSZsPTIwMjEwMTI5MTk0NjA1MDEwMDEwMDM1MDIxMDQwM0UxMEMmbHI9Jm1pbWVfdHlwZT12aWRlb19tcDQmcGw9MCZxcz0wJnJjPWFtZHhObk03YWp4b016TXpaVGN6TTBBcGFXWm5abVU3YVR0b056Um5aMlU2WkdkdmFUTm9aeTB6WGpaZ0xTMHZMUzl6YzE4dFlpOHZYell5WHpReU1UQXVOaTg2WXclM0QlM0Qmdmw9JnZyPQ==","check_info":"c:0-24637-b7a8|d:0-628554-d734,628555-1257110-a51c","p2p_verify_url":"aHR0cDovL3YzLWRlZmF1bHQuaXhpZ3VhLmNvbS82MjllYWZjNmIyNzNiMmI0NmQxY2E4ZmMzOTU5Yzg2Yi82MDE0MDNhMi92aWRlby90b3MvY24vdG9zLWNuLXZlLTQvOWU3MDk0MjNmZTFmNDgzOWEwYjQ3NTIwMDdlYTBiOWUv","user_video_proxy":1,"socket_buffer":10507860,"preload_size":327680,"preload_interval":60,"preload_min_step":5,"preload_max_step":10,"spade_a":"","kid":"","barrage_mask_url":"","barrage_mask_offset":""}
             * video_3 : {"definition":"720p","vtype":"mp4","vwidth":1280,"vheight":720,"bitrate":1168461,"size":3145207,"quality":"normal","codec_type":"h264","logo_type":"xigua","encrypt":false,"file_hash":"6db22a5acfa49cad9843d95aa18b3f98","file_id":"82f8f97dfa49436ca77f52e5773dc64e","main_url":"aHR0cDovL3YzLWRlZmF1bHQuaXhpZ3VhLmNvbS9kZDAzNTRlOWZhMjE3MWY5ZmYyYzJlMjI3YzRjMjg3OS82MDE0MDNhMi92aWRlby90b3MvY24vdG9zLWNuLXZlLTQvNmJjMjUzZDJhMjUzNDY2NTlmZDYzMDQ4ZmRmYjE4ZjIvP2E9MjAxMiZicj0zNDIzJmJ0PTExNDEmY2Q9MCU3QzAlN0MwJmNoPTAmY3I9MCZjcz0wJmRyPTAmZHM9MyZlcj0mbD0yMDIxMDEyOTE5NDYwNTAxMDAxMDAzNTAyMTA0MDNFMTBDJmxyPSZtaW1lX3R5cGU9dmlkZW9fbXA0JnBsPTAmcXM9MCZyYz1hbWR4Tm5NN2FqeG9Nek16WlRjek0wQXBOMlkyT21nNE9tUTVOemRwT21scE8yZHZhVE5vWnkwelhqWmdMUzB2TFM5emMySXpZVFF5TDJNMFlEQTJYbUUyTlM4Nll3JTNEJTNEJnZsPSZ2cj0=","backup_url_1":"aHR0cDovL3Y2LWRlZmF1bHQuaXhpZ3VhLmNvbS9jYTY4NmViMWM1OGM5MWQ0ZGM1ZTU5YTczNDc5YTNiNC82MDE0MDNhMi92aWRlby90b3MvY24vdG9zLWNuLXZlLTQvNmJjMjUzZDJhMjUzNDY2NTlmZDYzMDQ4ZmRmYjE4ZjIvP2E9MjAxMiZicj0zNDIzJmJ0PTExNDEmY2Q9MCU3QzAlN0MwJmNoPTAmY3I9MCZjcz0wJmRyPTAmZHM9MyZlcj0mbD0yMDIxMDEyOTE5NDYwNTAxMDAxMDAzNTAyMTA0MDNFMTBDJmxyPSZtaW1lX3R5cGU9dmlkZW9fbXA0JnBsPTAmcXM9MCZyYz1hbWR4Tm5NN2FqeG9Nek16WlRjek0wQXBOMlkyT21nNE9tUTVOemRwT21scE8yZHZhVE5vWnkwelhqWmdMUzB2TFM5emMySXpZVFF5TDJNMFlEQTJYbUUyTlM4Nll3JTNEJTNEJnZsPSZ2cj0=","check_info":"c:0-24106-5546|d:0-1572602-e256,1572603-3145206-eac5","p2p_verify_url":"aHR0cDovL3YzLWRlZmF1bHQuaXhpZ3VhLmNvbS8wODk0NGNiNzg0NDBhNjRkMDBlNDJlODAyOTY4MDlkMC82MDE0MDNhMi92aWRlby90b3MvY24vdG9zLWNuLXZlLTQvY2MzMmYxZjY4YWEzNDZjZGFkM2U5YWMwMDA1MmY4ZGUv","user_video_proxy":1,"socket_buffer":26290260,"preload_size":327680,"preload_interval":60,"preload_min_step":5,"preload_max_step":10,"spade_a":"","kid":"","barrage_mask_url":"","barrage_mask_offset":""}
             */

            private Video1Bean video_1;
            private Video2Bean video_2;
            private Video3Bean video_3;

            public Video1Bean getVideo_1() {
                return video_1;
            }

            public void setVideo_1(Video1Bean video_1) {
                this.video_1 = video_1;
            }

            public Video2Bean getVideo_2() {
                return video_2;
            }

            public void setVideo_2(Video2Bean video_2) {
                this.video_2 = video_2;
            }

            public Video3Bean getVideo_3() {
                return video_3;
            }

            public void setVideo_3(Video3Bean video_3) {
                this.video_3 = video_3;
            }

            @Override
            public String toString() {
                return "VideoListBean{" +
                        "video_1=" + video_1 +
                        ", video_2=" + video_2 +
                        ", video_3=" + video_3 +
                        '}';
            }

            public static class Video1Bean {
                /**
                 * definition : 360p
                 * vtype : mp4
                 * vwidth : 640
                 * vheight : 360
                 * bitrate : 323054
                 * size : 869583
                 * quality : normal
                 * codec_type : h264
                 * logo_type : xigua
                 * encrypt : false
                 * file_hash : ae156d3d803c4cb2cedfbc8f5243acce
                 * file_id : c73178ac3ccb4e4bb28243f0bb582e0e
                 * main_url : aHR0cDovL3YzLWRlZmF1bHQuaXhpZ3VhLmNvbS9kMDIzZWQwMzU3ZmZiNjE0ZDZkOTExY2I5YjY0Nzg3ZC82MDE0MDNhMi92aWRlby90b3MvY24vdG9zLWNuLXZlLTQvMmJmODdhYjI1NDk1NDMxMWI2ZjM3N2JmYzYxYjIyY2MvP2E9MjAxMiZicj05NDUmYnQ9MzE1JmNkPTAlN0MwJTdDMCZjaD0wJmNyPTAmY3M9MCZkcj0wJmRzPTEmZXI9Jmw9MjAyMTAxMjkxOTQ2MDUwMTAwMTAwMzUwMjEwNDAzRTEwQyZscj0mbWltZV90eXBlPXZpZGVvX21wNCZwbD0wJnFzPTAmcmM9YW1keE5uTTdhanhvTXpNelpUY3pNMEFwTXpVNFpXazNPMlUzTjJZMlpEbzJabWR2YVROb1p5MHpYalpnTFMwdkxTOXpjMkppTlY4dE1DOHZYMkpmWUdBMUxqUTZZdyUzRCUzRCZ2bD0mdnI9
                 * backup_url_1 : aHR0cDovL3Y2LWRlZmF1bHQuaXhpZ3VhLmNvbS80ZDI0NDkyNjBjMTE3NGQwMzRiYWFhM2Y0ZDQ0NzlkNC82MDE0MDNhMi92aWRlby90b3MvY24vdG9zLWNuLXZlLTQvMmJmODdhYjI1NDk1NDMxMWI2ZjM3N2JmYzYxYjIyY2MvP2E9MjAxMiZicj05NDUmYnQ9MzE1JmNkPTAlN0MwJTdDMCZjaD0wJmNyPTAmY3M9MCZkcj0wJmRzPTEmZXI9Jmw9MjAyMTAxMjkxOTQ2MDUwMTAwMTAwMzUwMjEwNDAzRTEwQyZscj0mbWltZV90eXBlPXZpZGVvX21wNCZwbD0wJnFzPTAmcmM9YW1keE5uTTdhanhvTXpNelpUY3pNMEFwTXpVNFpXazNPMlUzTjJZMlpEbzJabWR2YVROb1p5MHpYalpnTFMwdkxTOXpjMkppTlY4dE1DOHZYMkpmWUdBMUxqUTZZdyUzRCUzRCZ2bD0mdnI9
                 * check_info : c:0-24853-58d9|d:0-434790-f598,434791-869582-effc
                 * p2p_verify_url : aHR0cDovL3YzLWRlZmF1bHQuaXhpZ3VhLmNvbS81ZDBhYWNjZDI4NWU5YzQzNzQ0ZjE5YjEyMDMwMmMwNy82MDE0MDNhMi92aWRlby90b3MvY24vdG9zLWNuLXZlLTQvODUyNDY5NjhiMDlmNGRiNjkzMGQ2YjQyMDQxMTY4OWUv
                 * user_video_proxy : 1
                 * socket_buffer : 7268580
                 * preload_size : 327680
                 * preload_interval : 60
                 * preload_min_step : 5
                 * preload_max_step : 10
                 * spade_a :
                 * kid :
                 * barrage_mask_url :
                 * barrage_mask_offset :
                 */

                private String definition;
                private String vtype;
                private int vwidth;
                private int vheight;
                private int bitrate;
                private int size;
                private String quality;
                private String codec_type;
                private String logo_type;
                private boolean encrypt;
                private String file_hash;
                private String file_id;
                private String main_url;
                private String backup_url_1;
                private String check_info;
                private String p2p_verify_url;
                private int user_video_proxy;
                private int socket_buffer;
                private int preload_size;
                private int preload_interval;
                private int preload_min_step;
                private int preload_max_step;
                private String spade_a;
                private String kid;
                private String barrage_mask_url;
                private String barrage_mask_offset;

                public String getDefinition() {
                    return definition;
                }

                public void setDefinition(String definition) {
                    this.definition = definition;
                }

                public String getVtype() {
                    return vtype;
                }

                public void setVtype(String vtype) {
                    this.vtype = vtype;
                }

                public int getVwidth() {
                    return vwidth;
                }

                public void setVwidth(int vwidth) {
                    this.vwidth = vwidth;
                }

                public int getVheight() {
                    return vheight;
                }

                public void setVheight(int vheight) {
                    this.vheight = vheight;
                }

                public int getBitrate() {
                    return bitrate;
                }

                public void setBitrate(int bitrate) {
                    this.bitrate = bitrate;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public String getQuality() {
                    return quality;
                }

                public void setQuality(String quality) {
                    this.quality = quality;
                }

                public String getCodec_type() {
                    return codec_type;
                }

                public void setCodec_type(String codec_type) {
                    this.codec_type = codec_type;
                }

                public String getLogo_type() {
                    return logo_type;
                }

                public void setLogo_type(String logo_type) {
                    this.logo_type = logo_type;
                }

                public boolean isEncrypt() {
                    return encrypt;
                }

                public void setEncrypt(boolean encrypt) {
                    this.encrypt = encrypt;
                }

                public String getFile_hash() {
                    return file_hash;
                }

                public void setFile_hash(String file_hash) {
                    this.file_hash = file_hash;
                }

                public String getFile_id() {
                    return file_id;
                }

                public void setFile_id(String file_id) {
                    this.file_id = file_id;
                }

                public String getMain_url() {
                    return main_url;
                }

                public void setMain_url(String main_url) {
                    this.main_url = main_url;
                }

                public String getBackup_url_1() {
                    return backup_url_1;
                }

                public void setBackup_url_1(String backup_url_1) {
                    this.backup_url_1 = backup_url_1;
                }

                public String getCheck_info() {
                    return check_info;
                }

                public void setCheck_info(String check_info) {
                    this.check_info = check_info;
                }

                public String getP2p_verify_url() {
                    return p2p_verify_url;
                }

                public void setP2p_verify_url(String p2p_verify_url) {
                    this.p2p_verify_url = p2p_verify_url;
                }

                public int getUser_video_proxy() {
                    return user_video_proxy;
                }

                public void setUser_video_proxy(int user_video_proxy) {
                    this.user_video_proxy = user_video_proxy;
                }

                public int getSocket_buffer() {
                    return socket_buffer;
                }

                public void setSocket_buffer(int socket_buffer) {
                    this.socket_buffer = socket_buffer;
                }

                public int getPreload_size() {
                    return preload_size;
                }

                public void setPreload_size(int preload_size) {
                    this.preload_size = preload_size;
                }

                public int getPreload_interval() {
                    return preload_interval;
                }

                public void setPreload_interval(int preload_interval) {
                    this.preload_interval = preload_interval;
                }

                public int getPreload_min_step() {
                    return preload_min_step;
                }

                public void setPreload_min_step(int preload_min_step) {
                    this.preload_min_step = preload_min_step;
                }

                public int getPreload_max_step() {
                    return preload_max_step;
                }

                public void setPreload_max_step(int preload_max_step) {
                    this.preload_max_step = preload_max_step;
                }

                public String getSpade_a() {
                    return spade_a;
                }

                public void setSpade_a(String spade_a) {
                    this.spade_a = spade_a;
                }

                public String getKid() {
                    return kid;
                }

                public void setKid(String kid) {
                    this.kid = kid;
                }

                public String getBarrage_mask_url() {
                    return barrage_mask_url;
                }

                public void setBarrage_mask_url(String barrage_mask_url) {
                    this.barrage_mask_url = barrage_mask_url;
                }

                public String getBarrage_mask_offset() {
                    return barrage_mask_offset;
                }

                public void setBarrage_mask_offset(String barrage_mask_offset) {
                    this.barrage_mask_offset = barrage_mask_offset;
                }
            }

            public static class Video2Bean {
                /**
                 * definition : 480p
                 * vtype : mp4
                 * vwidth : 854
                 * vheight : 480
                 * bitrate : 467023
                 * size : 1257111
                 * quality : normal
                 * codec_type : h264
                 * logo_type : xigua
                 * encrypt : false
                 * file_hash : d408d4f85ce8dc2bc9ecaaa6c94128ac
                 * file_id : a279b1d3d41547eb85f98bb2c2dec0fb
                 * main_url : aHR0cDovL3YzLWRlZmF1bHQuaXhpZ3VhLmNvbS9kMzI2ZGUyMWVmODIxY2E0ZjgxOTE5MzhlZjFlNTAzZC82MDE0MDNhMi92aWRlby90b3MvY24vdG9zLWNuLXZlLTQvNTRhOTZmNGEyMTZiNGEzOWEzYTcxODA2ODM1MDg0NDQvP2E9MjAxMiZicj0xMzY4JmJ0PTQ1NiZjZD0wJTdDMCU3QzAmY2g9MCZjcj0wJmNzPTAmZHI9MCZkcz0yJmVyPSZsPTIwMjEwMTI5MTk0NjA1MDEwMDEwMDM1MDIxMDQwM0UxMEMmbHI9Jm1pbWVfdHlwZT12aWRlb19tcDQmcGw9MCZxcz0wJnJjPWFtZHhObk03YWp4b016TXpaVGN6TTBBcGFXWm5abVU3YVR0b056Um5aMlU2WkdkdmFUTm9aeTB6WGpaZ0xTMHZMUzl6YzE4dFlpOHZYell5WHpReU1UQXVOaTg2WXclM0QlM0Qmdmw9JnZyPQ==
                 * backup_url_1 : aHR0cDovL3Y2LWRlZmF1bHQuaXhpZ3VhLmNvbS8xNjRlOGFjM2Q2YTBiNWY0YjdjMzkyNWU2ZWU2ZGYwNy82MDE0MDNhMi92aWRlby90b3MvY24vdG9zLWNuLXZlLTQvNTRhOTZmNGEyMTZiNGEzOWEzYTcxODA2ODM1MDg0NDQvP2E9MjAxMiZicj0xMzY4JmJ0PTQ1NiZjZD0wJTdDMCU3QzAmY2g9MCZjcj0wJmNzPTAmZHI9MCZkcz0yJmVyPSZsPTIwMjEwMTI5MTk0NjA1MDEwMDEwMDM1MDIxMDQwM0UxMEMmbHI9Jm1pbWVfdHlwZT12aWRlb19tcDQmcGw9MCZxcz0wJnJjPWFtZHhObk03YWp4b016TXpaVGN6TTBBcGFXWm5abVU3YVR0b056Um5aMlU2WkdkdmFUTm9aeTB6WGpaZ0xTMHZMUzl6YzE4dFlpOHZYell5WHpReU1UQXVOaTg2WXclM0QlM0Qmdmw9JnZyPQ==
                 * check_info : c:0-24637-b7a8|d:0-628554-d734,628555-1257110-a51c
                 * p2p_verify_url : aHR0cDovL3YzLWRlZmF1bHQuaXhpZ3VhLmNvbS82MjllYWZjNmIyNzNiMmI0NmQxY2E4ZmMzOTU5Yzg2Yi82MDE0MDNhMi92aWRlby90b3MvY24vdG9zLWNuLXZlLTQvOWU3MDk0MjNmZTFmNDgzOWEwYjQ3NTIwMDdlYTBiOWUv
                 * user_video_proxy : 1
                 * socket_buffer : 10507860
                 * preload_size : 327680
                 * preload_interval : 60
                 * preload_min_step : 5
                 * preload_max_step : 10
                 * spade_a :
                 * kid :
                 * barrage_mask_url :
                 * barrage_mask_offset :
                 */

                private String definition;
                private String vtype;
                private int vwidth;
                private int vheight;
                private int bitrate;
                private int size;
                private String quality;
                private String codec_type;
                private String logo_type;
                private boolean encrypt;
                private String file_hash;
                private String file_id;
                private String main_url;
                private String backup_url_1;
                private String check_info;
                private String p2p_verify_url;
                private int user_video_proxy;
                private int socket_buffer;
                private int preload_size;
                private int preload_interval;
                private int preload_min_step;
                private int preload_max_step;
                private String spade_a;
                private String kid;
                private String barrage_mask_url;
                private String barrage_mask_offset;

                public String getDefinition() {
                    return definition;
                }

                public void setDefinition(String definition) {
                    this.definition = definition;
                }

                public String getVtype() {
                    return vtype;
                }

                public void setVtype(String vtype) {
                    this.vtype = vtype;
                }

                public int getVwidth() {
                    return vwidth;
                }

                public void setVwidth(int vwidth) {
                    this.vwidth = vwidth;
                }

                public int getVheight() {
                    return vheight;
                }

                public void setVheight(int vheight) {
                    this.vheight = vheight;
                }

                public int getBitrate() {
                    return bitrate;
                }

                public void setBitrate(int bitrate) {
                    this.bitrate = bitrate;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public String getQuality() {
                    return quality;
                }

                public void setQuality(String quality) {
                    this.quality = quality;
                }

                public String getCodec_type() {
                    return codec_type;
                }

                public void setCodec_type(String codec_type) {
                    this.codec_type = codec_type;
                }

                public String getLogo_type() {
                    return logo_type;
                }

                public void setLogo_type(String logo_type) {
                    this.logo_type = logo_type;
                }

                public boolean isEncrypt() {
                    return encrypt;
                }

                public void setEncrypt(boolean encrypt) {
                    this.encrypt = encrypt;
                }

                public String getFile_hash() {
                    return file_hash;
                }

                public void setFile_hash(String file_hash) {
                    this.file_hash = file_hash;
                }

                public String getFile_id() {
                    return file_id;
                }

                public void setFile_id(String file_id) {
                    this.file_id = file_id;
                }

                public String getMain_url() {
                    return main_url;
                }

                public void setMain_url(String main_url) {
                    this.main_url = main_url;
                }

                public String getBackup_url_1() {
                    return backup_url_1;
                }

                public void setBackup_url_1(String backup_url_1) {
                    this.backup_url_1 = backup_url_1;
                }

                public String getCheck_info() {
                    return check_info;
                }

                public void setCheck_info(String check_info) {
                    this.check_info = check_info;
                }

                public String getP2p_verify_url() {
                    return p2p_verify_url;
                }

                public void setP2p_verify_url(String p2p_verify_url) {
                    this.p2p_verify_url = p2p_verify_url;
                }

                public int getUser_video_proxy() {
                    return user_video_proxy;
                }

                public void setUser_video_proxy(int user_video_proxy) {
                    this.user_video_proxy = user_video_proxy;
                }

                public int getSocket_buffer() {
                    return socket_buffer;
                }

                public void setSocket_buffer(int socket_buffer) {
                    this.socket_buffer = socket_buffer;
                }

                public int getPreload_size() {
                    return preload_size;
                }

                public void setPreload_size(int preload_size) {
                    this.preload_size = preload_size;
                }

                public int getPreload_interval() {
                    return preload_interval;
                }

                public void setPreload_interval(int preload_interval) {
                    this.preload_interval = preload_interval;
                }

                public int getPreload_min_step() {
                    return preload_min_step;
                }

                public void setPreload_min_step(int preload_min_step) {
                    this.preload_min_step = preload_min_step;
                }

                public int getPreload_max_step() {
                    return preload_max_step;
                }

                public void setPreload_max_step(int preload_max_step) {
                    this.preload_max_step = preload_max_step;
                }

                public String getSpade_a() {
                    return spade_a;
                }

                public void setSpade_a(String spade_a) {
                    this.spade_a = spade_a;
                }

                public String getKid() {
                    return kid;
                }

                public void setKid(String kid) {
                    this.kid = kid;
                }

                public String getBarrage_mask_url() {
                    return barrage_mask_url;
                }

                public void setBarrage_mask_url(String barrage_mask_url) {
                    this.barrage_mask_url = barrage_mask_url;
                }

                public String getBarrage_mask_offset() {
                    return barrage_mask_offset;
                }

                public void setBarrage_mask_offset(String barrage_mask_offset) {
                    this.barrage_mask_offset = barrage_mask_offset;
                }
            }

            public static class Video3Bean {
                /**
                 * definition : 720p
                 * vtype : mp4
                 * vwidth : 1280
                 * vheight : 720
                 * bitrate : 1168461
                 * size : 3145207
                 * quality : normal
                 * codec_type : h264
                 * logo_type : xigua
                 * encrypt : false
                 * file_hash : 6db22a5acfa49cad9843d95aa18b3f98
                 * file_id : 82f8f97dfa49436ca77f52e5773dc64e
                 * main_url : aHR0cDovL3YzLWRlZmF1bHQuaXhpZ3VhLmNvbS9kZDAzNTRlOWZhMjE3MWY5ZmYyYzJlMjI3YzRjMjg3OS82MDE0MDNhMi92aWRlby90b3MvY24vdG9zLWNuLXZlLTQvNmJjMjUzZDJhMjUzNDY2NTlmZDYzMDQ4ZmRmYjE4ZjIvP2E9MjAxMiZicj0zNDIzJmJ0PTExNDEmY2Q9MCU3QzAlN0MwJmNoPTAmY3I9MCZjcz0wJmRyPTAmZHM9MyZlcj0mbD0yMDIxMDEyOTE5NDYwNTAxMDAxMDAzNTAyMTA0MDNFMTBDJmxyPSZtaW1lX3R5cGU9dmlkZW9fbXA0JnBsPTAmcXM9MCZyYz1hbWR4Tm5NN2FqeG9Nek16WlRjek0wQXBOMlkyT21nNE9tUTVOemRwT21scE8yZHZhVE5vWnkwelhqWmdMUzB2TFM5emMySXpZVFF5TDJNMFlEQTJYbUUyTlM4Nll3JTNEJTNEJnZsPSZ2cj0=
                 * backup_url_1 : aHR0cDovL3Y2LWRlZmF1bHQuaXhpZ3VhLmNvbS9jYTY4NmViMWM1OGM5MWQ0ZGM1ZTU5YTczNDc5YTNiNC82MDE0MDNhMi92aWRlby90b3MvY24vdG9zLWNuLXZlLTQvNmJjMjUzZDJhMjUzNDY2NTlmZDYzMDQ4ZmRmYjE4ZjIvP2E9MjAxMiZicj0zNDIzJmJ0PTExNDEmY2Q9MCU3QzAlN0MwJmNoPTAmY3I9MCZjcz0wJmRyPTAmZHM9MyZlcj0mbD0yMDIxMDEyOTE5NDYwNTAxMDAxMDAzNTAyMTA0MDNFMTBDJmxyPSZtaW1lX3R5cGU9dmlkZW9fbXA0JnBsPTAmcXM9MCZyYz1hbWR4Tm5NN2FqeG9Nek16WlRjek0wQXBOMlkyT21nNE9tUTVOemRwT21scE8yZHZhVE5vWnkwelhqWmdMUzB2TFM5emMySXpZVFF5TDJNMFlEQTJYbUUyTlM4Nll3JTNEJTNEJnZsPSZ2cj0=
                 * check_info : c:0-24106-5546|d:0-1572602-e256,1572603-3145206-eac5
                 * p2p_verify_url : aHR0cDovL3YzLWRlZmF1bHQuaXhpZ3VhLmNvbS8wODk0NGNiNzg0NDBhNjRkMDBlNDJlODAyOTY4MDlkMC82MDE0MDNhMi92aWRlby90b3MvY24vdG9zLWNuLXZlLTQvY2MzMmYxZjY4YWEzNDZjZGFkM2U5YWMwMDA1MmY4ZGUv
                 * user_video_proxy : 1
                 * socket_buffer : 26290260
                 * preload_size : 327680
                 * preload_interval : 60
                 * preload_min_step : 5
                 * preload_max_step : 10
                 * spade_a :
                 * kid :
                 * barrage_mask_url :
                 * barrage_mask_offset :
                 */

                private String definition;
                private String vtype;
                private int vwidth;
                private int vheight;
                private int bitrate;
                private int size;
                private String quality;
                private String codec_type;
                private String logo_type;
                private boolean encrypt;
                private String file_hash;
                private String file_id;
                private String main_url;
                private String backup_url_1;
                private String check_info;
                private String p2p_verify_url;
                private int user_video_proxy;
                private int socket_buffer;
                private int preload_size;
                private int preload_interval;
                private int preload_min_step;
                private int preload_max_step;
                private String spade_a;
                private String kid;
                private String barrage_mask_url;
                private String barrage_mask_offset;

                public String getDefinition() {
                    return definition;
                }

                public void setDefinition(String definition) {
                    this.definition = definition;
                }

                public String getVtype() {
                    return vtype;
                }

                public void setVtype(String vtype) {
                    this.vtype = vtype;
                }

                public int getVwidth() {
                    return vwidth;
                }

                public void setVwidth(int vwidth) {
                    this.vwidth = vwidth;
                }

                public int getVheight() {
                    return vheight;
                }

                public void setVheight(int vheight) {
                    this.vheight = vheight;
                }

                public int getBitrate() {
                    return bitrate;
                }

                public void setBitrate(int bitrate) {
                    this.bitrate = bitrate;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public String getQuality() {
                    return quality;
                }

                public void setQuality(String quality) {
                    this.quality = quality;
                }

                public String getCodec_type() {
                    return codec_type;
                }

                public void setCodec_type(String codec_type) {
                    this.codec_type = codec_type;
                }

                public String getLogo_type() {
                    return logo_type;
                }

                public void setLogo_type(String logo_type) {
                    this.logo_type = logo_type;
                }

                public boolean isEncrypt() {
                    return encrypt;
                }

                public void setEncrypt(boolean encrypt) {
                    this.encrypt = encrypt;
                }

                public String getFile_hash() {
                    return file_hash;
                }

                public void setFile_hash(String file_hash) {
                    this.file_hash = file_hash;
                }

                public String getFile_id() {
                    return file_id;
                }

                public void setFile_id(String file_id) {
                    this.file_id = file_id;
                }

                public String getMain_url() {
                    return main_url;
                }

                public void setMain_url(String main_url) {
                    this.main_url = main_url;
                }

                public String getBackup_url_1() {
                    return backup_url_1;
                }

                public void setBackup_url_1(String backup_url_1) {
                    this.backup_url_1 = backup_url_1;
                }

                public String getCheck_info() {
                    return check_info;
                }

                public void setCheck_info(String check_info) {
                    this.check_info = check_info;
                }

                public String getP2p_verify_url() {
                    return p2p_verify_url;
                }

                public void setP2p_verify_url(String p2p_verify_url) {
                    this.p2p_verify_url = p2p_verify_url;
                }

                public int getUser_video_proxy() {
                    return user_video_proxy;
                }

                public void setUser_video_proxy(int user_video_proxy) {
                    this.user_video_proxy = user_video_proxy;
                }

                public int getSocket_buffer() {
                    return socket_buffer;
                }

                public void setSocket_buffer(int socket_buffer) {
                    this.socket_buffer = socket_buffer;
                }

                public int getPreload_size() {
                    return preload_size;
                }

                public void setPreload_size(int preload_size) {
                    this.preload_size = preload_size;
                }

                public int getPreload_interval() {
                    return preload_interval;
                }

                public void setPreload_interval(int preload_interval) {
                    this.preload_interval = preload_interval;
                }

                public int getPreload_min_step() {
                    return preload_min_step;
                }

                public void setPreload_min_step(int preload_min_step) {
                    this.preload_min_step = preload_min_step;
                }

                public int getPreload_max_step() {
                    return preload_max_step;
                }

                public void setPreload_max_step(int preload_max_step) {
                    this.preload_max_step = preload_max_step;
                }

                public String getSpade_a() {
                    return spade_a;
                }

                public void setSpade_a(String spade_a) {
                    this.spade_a = spade_a;
                }

                public String getKid() {
                    return kid;
                }

                public void setKid(String kid) {
                    this.kid = kid;
                }

                public String getBarrage_mask_url() {
                    return barrage_mask_url;
                }

                public void setBarrage_mask_url(String barrage_mask_url) {
                    this.barrage_mask_url = barrage_mask_url;
                }

                public String getBarrage_mask_offset() {
                    return barrage_mask_offset;
                }

                public void setBarrage_mask_offset(String barrage_mask_offset) {
                    this.barrage_mask_offset = barrage_mask_offset;
                }
            }
        }

        public static class BigThumbsBean {
            /**
             * img_num : 22
             * uri : 36d30000e9b4731d4c042
             * img_url : http://p3-tt.bytecdn.cn/origin/36d30000e9b4731d4c042
             * img_urls : ["http://p3-tt.bytecdn.cn/origin/36d30000e9b4731d4c042"]
             * img_x_size : 240
             * img_y_size : 136
             * img_x_len : 10
             * img_y_len : 3
             * duration : 21.480333
             * interval : 1
             * fext : jpg
             */

            private int img_num;
            private String uri;
            private String img_url;
            private int img_x_size;
            private int img_y_size;
            private int img_x_len;
            private int img_y_len;
            private double duration;
            private int interval;
            private String fext;
            private List<String> img_urls;

            public int getImg_num() {
                return img_num;
            }

            public void setImg_num(int img_num) {
                this.img_num = img_num;
            }

            public String getUri() {
                return uri;
            }

            public void setUri(String uri) {
                this.uri = uri;
            }

            public String getImg_url() {
                return img_url;
            }

            public void setImg_url(String img_url) {
                this.img_url = img_url;
            }

            public int getImg_x_size() {
                return img_x_size;
            }

            public void setImg_x_size(int img_x_size) {
                this.img_x_size = img_x_size;
            }

            public int getImg_y_size() {
                return img_y_size;
            }

            public void setImg_y_size(int img_y_size) {
                this.img_y_size = img_y_size;
            }

            public int getImg_x_len() {
                return img_x_len;
            }

            public void setImg_x_len(int img_x_len) {
                this.img_x_len = img_x_len;
            }

            public int getImg_y_len() {
                return img_y_len;
            }

            public void setImg_y_len(int img_y_len) {
                this.img_y_len = img_y_len;
            }

            public double getDuration() {
                return duration;
            }

            public void setDuration(double duration) {
                this.duration = duration;
            }

            public int getInterval() {
                return interval;
            }

            public void setInterval(int interval) {
                this.interval = interval;
            }

            public String getFext() {
                return fext;
            }

            public void setFext(String fext) {
                this.fext = fext;
            }

            public List<String> getImg_urls() {
                return img_urls;
            }

            public void setImg_urls(List<String> img_urls) {
                this.img_urls = img_urls;
            }
        }
    }

    @Override
    public String toString() {
        return "NetBeans{" +
                "data=" + data +
                ", message='" + message + '\'' +
                ", code=" + code +
                ", total=" + total +
                '}';
    }
}

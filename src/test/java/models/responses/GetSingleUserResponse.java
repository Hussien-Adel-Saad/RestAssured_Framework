package models.responses;

public class GetSingleUserResponse {
    private Data data;
    private Support support;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

    public static class Data {
        private String id;
        private String email;
        private String first_name;
        private String last_name;
        private String avatar;

        // Getters and Setters
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getFirst_name() { return first_name; }
        public void setFirst_name(String first_name) { this.first_name = first_name; }

        public String getLast_name() { return last_name; }
        public void setLast_name(String last_name) { this.last_name = last_name; }

        public String getAvatar() { return avatar; }
        public void setAvatar(String avatar) { this.avatar = avatar; }
    }

    public static class Support {
        private String url;
        private String text;

        // Getters and Setters
        public String getUrl() { return url; }
        public void setUrl(String url) { this.url = url; }

        public String getText() { return text; }
        public void setText(String text) { this.text = text; }
    }
}



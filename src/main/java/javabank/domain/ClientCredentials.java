package javabank.domain;

import java.util.Objects;

public class ClientCredentials extends Entity<Long>{
    private String username;
    private String password;
    private String salt;

    /**
     * Constructor that creates a new ClientCredentials
     * @param username String, representing the username of the Client
     * @param password String, representing the password of the Client
     * @param salt String, representing the salt value used in password encryption
     */
    public ClientCredentials(String username, String password, String salt) {
        this.username = username;
        this.password = password;
        this.salt = salt;
    }

    /**
     * @return String, representing the username of the Client
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username String, representing the new username of the Client
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return String, representing the password of the Client
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password String, representing the new password of the Client
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return String, representing the salt value of the Client
     */
    public String getSalt() {
        return salt;
    }

    /**
     * @param salt String, representing the new salt value of the Client
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * @return String, representing the serialization of a ClientCredentials
     */
    @Override
    public String toString() {
        return "ClientCredentials{" +
                "ID='" + getId() + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }

    /**
     * @param obj Object, representing the Object to be verified
     * @return  true,   if the username of the Client is equal to the username of the Object,
     *                  the password of the Client is equal to the password of the Object
     *                  and the salt string of the Client is equal to the salt string of the Object
     *          false,  otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ClientCredentials that = (ClientCredentials) obj;
        return username.equals(that.username) && password.equals(that.password) && salt.equals(that.salt);
    }

    /**
     * @return int, representing the hashCode of the ClientCredentials
     */
    @Override
    public int hashCode() {
        return Objects.hash(username, password, salt);
    }
}

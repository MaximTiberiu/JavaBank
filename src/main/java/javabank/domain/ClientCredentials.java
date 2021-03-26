package javabank.domain;

import java.util.Objects;

public class ClientCredentials {
    private String username;
    private String password;

    /**
     * Constructor that creates a new ClientCredentials
     * @param username String, representing the username of the Client
     * @param password String, representing the password of the Client
     */
    public ClientCredentials(String username, String password) {
        this.username = username;
        this.password = password;
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
     * @return String, representing the serialization of a ClientCredentials | TODO: Implement Serialization
     */
    @Override
    public String toString() {
        return "ClientCredentials{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    /**
     * @param obj Object, representing the Object to be verified
     * @return  true,   if the username of the Client is equal to the username of the Object
     *                  and the password of the Client is equal to the password of the Object
     *          false,  otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ClientCredentials that = (ClientCredentials) obj;
        return username.equals(that.username) && password.equals(that.password);
    }

    /**
     * @return int, representing the hashCode of the ClientCredentials
     */
    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}

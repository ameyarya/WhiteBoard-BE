function UserObj(username, password, firstName, lastName, role) {

    this.username = username;
    this.password = password;
    this.firstname = firstName;
    this.lastname = lastName;
    this.role = role;

    this.setUsername = setUsername;
    this.getUsername = getUsername;

    this.setPassword = setPassword;
    this.getPassword = getPassword;

    this.setFirstName = setFirstName;
    this.getFirstName = getFirstName;

    this.setLastName = setLastName;
    this.getLastName = getLastName;

    this.setRole = setRole;
    this.getRole = getRole;

    function setUsername(username) {
        this.username = username;
    }

    function getUsername() {
        return this.username;
    }

    function setPassword(username) {
        this.password = password;
    }

    function getPassword() {
        return this.password;
    }

    function setFirstName(username) {
        this.username = username;
    }

    function getFirstName() {
        return this.username;
    }

    function setLastName(username) {
        this.username = username;
    }

    function getLastName() {
        return this.username;
    }

    function setRole(username) {
        this.username = username;
    }

    function getRole() {
        return this.username;
    }

}

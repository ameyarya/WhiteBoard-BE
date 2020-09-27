(function () {

    let userService = new AdminUserServiceClient();
    let userObj = new UserObj();
    let $userName, $password, $firstName, $lastName, $role;
    let $searchBtn, $createBtn, $updateBtn;
    let $tableBody, $templateRow;
    let users = [];

    let main = () => {

        $userName = $("#usernameFld");
        $password = $("#passwordFld");
        $firstName = $("#firstNameFld");
        $lastName = $("#lastNameFld");
        $role = $("#roleFld");

        userObj = new UserObj($userName, $password, $firstName, $lastName, $role);

        $searchBtn = $("#searchBtn");
        $createBtn = $("#createBtn");
        $updateBtn = $("#updateBtn");

        $templateRow = $("#templateRow");
        $tableBody = $("#tableBody");

        $searchBtn.click(searchUser);
        $createBtn.click(createUser);
        $updateBtn.click(updateUser);

        userService
            .findAllUsers()
            .then(theUsers => {
                users = theUsers;
                renderUsers()
            })

    };

    function createUser() {

        $tableBody.empty();

        const userName = $userName.val();
        $userName.val("");
        const password = $password.val();
        $password.val("");
        const firstName = $firstName.val();
        $firstName.val("");
        const lastName = $lastName.val();
        $lastName.val("");
        const role = $role.val();
        $role.val("");

        const newUser = {
            username: userName,
            password: password,
            firstname: firstName,
            lastname: lastName,
            role: role,
        };

        userService.createUser(newUser)
            .then(() => {
                findAllUsers()
            })

    }

    function updateUser() {

        $tableBody.empty();

        const updatedUser = {
            username: $userName.val(),
            password: $password.val(),
            firstname: $firstName.val(),
            lastname: $lastName.val(),
            role: $role.val()
        };
        $userName.val("");
        $password.val("");
        $firstName.val("");
        $lastName.val("");
        $role.val("");
        updatedUser._id = users[currentUserIndex]._id;
        userService.updateUser(updatedUser._id, updatedUser)
            .then((actualUser) => {
                findAllUsers()
            })

    }

    function deleteUser(index) {

        $tableBody.empty();

        let user = users[index];
        let userId = user._id;

        userService.deleteUser(userId)
            .then(() => {
                users.splice(index, 1);
                renderUsers()
            })

    }

    function searchUser() {

        $tableBody.empty();

        const userName = $userName.val();
        const firstName = $firstName.val();
        const lastName = $lastName.val();
        const role = $role.val();

        let userList = [];

        for (let u in users) {
            const user = users[u];
            if (userName === user.username) {
                userList.push(user);
            }
            if (firstName === user.firstname) {
                userList.push(user);
            }
            if (lastName === user.lastname) {
                userList.push(user);
            }
            if (role === user.role) {
                userList.push(user);
            }
        }

        users = userList;
        renderUsers();
        userList.length = 0;

    }

    let currentUserIndex = -1;

    function selectUser(index) {
        currentUserIndex = index;
        let user = users[index];
        let userId = user._id;

        userService.findUserById(userId)
            .then(actualUser => {
                $userName.val(actualUser.username);
                $password.val(actualUser.password);
                $firstName.val(actualUser.firstname);
                $lastName.val(actualUser.lastname);
                $role.val(actualUser.role)
            })
    }

    function findUserByID(index) {
        userService
            .findUserById(index)
            .then(() => {
                    renderUser(index)
                }
            )
    }

    function renderUser(index) {

        let user = users[index];
        const templateRowClone = $templateRow.clone();
        templateRowClone.css("display", "table-row");
        templateRowClone.removeAttr("id");
        templateRowClone.find(".wbdv-username").html(user.username);
        templateRowClone.find(".wbdv-first-name").html(user.firstname);
        templateRowClone.find(".wbdv-last-name").html(user.lastname);
        templateRowClone.find(".wbdv-role").html(user.role);
        templateRowClone.find(".deleteBtn").click(() => deleteUser(user));
        templateRowClone.find(".editBtn").click(() => selectUser(user));
        $tableBody.append(templateRowClone);

    }

    function findAllUsers() {
        userService
            .findAllUsers()
            .then(theUsers => {
                users = theUsers;
                renderUsers()
            })
    }

    function renderUsers() {
        for (let u in users) {
            let user = users[u];
            const templateRowClone = $templateRow.clone();
            templateRowClone.css("display", "table-row");
            templateRowClone.removeAttr("id");
            templateRowClone.find(".wbdv-username").html(user.username);
            templateRowClone.find(".wbdv-first-name").html(user.firstname);
            templateRowClone.find(".wbdv-last-name").html(user.lastname);
            templateRowClone.find(".wbdv-role").html(user.role);
            templateRowClone.find(".deleteBtn").click(() => deleteUser(u));
            templateRowClone.find(".editBtn").click(() => selectUser(u));
            $tableBody.append(templateRowClone);
        }
    }

    $(main);

})();

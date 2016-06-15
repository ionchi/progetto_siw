function checkPass()
{
    //Store the password field objects into variables ...
    var password = document.getElementById('password');
    var password_confirmation = document.getElementById('password_confirmation');
    //Store the Confimation Message Object ...
    var message = document.getElementById('confirmMessage');
    //Set the colors we will be using ...
    var goodColor = "#66cc66";
    var badColor = "#ff6666";
    //Compare the values in the password field 
    //and the confirmation field
    if(password.value == password_confirmation.value){
        //The passwords match. 
        //Set the color to the good color and inform
        //the user that they have entered the correct password 
        password_confirmation.style.backgroundColor = goodColor;
        message.style.color = goodColor;
        message.innerHTML = "Passwords Match!"
    }else{
        //The passwords do not match.
        //Set the color to the bad color and
        //notify the user.
        password_confirmation.style.backgroundColor = badColor;
        message.style.color = badColor;
        message.innerHTML = "Passwords Do Not Match!"
    }
}  
Water my plants - Java Backend

Welcome to the Water My Plants API! 

BaseURL = water--my--plants.herokuapp.com

To see this API in use, see the front end implemented at https://water-my-plants-java-frontend.vercel.app/signup (code at https://github.com/taylorfriesen6/frontend, which is a fork of https://github.com/WaterMyPlants-tt14/frontend)

Endpoints: 

#Authentication

## REGISTER: 
BaseURL/createnewaccount

Parameters:
| Name         | Type    | Required 
| ------------ | ------- | --------
| name         | string  | yes
| email        | string  | yes       
| phone | string  | yes  
| password     | string  | yes  

[POST] body example:

{
  name: 'testName',
  email: 'test@gmail.com',
  phone: '555-555-5555',
  password: 'testPassword',
}

RETURNS

{
  access_token: an OAuth2 access token
}

## LOGIN: 
BaseURL/login

Oauth2 password authentication using the following values:
username: the user's email
password: the user's password
client id: lambda-client
client secret: lambda-secret


RETURNS: 
    {
        access_token: an OAuth2 access token
    }

All following endpoints are restricted and require the OAuth2 token to be sent in the header

#Users

BaseURL/api/users

[GET] Get the logged-in user

RETURNS:

{
  user_id: 1
  name: 'testName',
  email: 'test@gmail.com',
  phone_number: '(555) 555-5555',
  password: 'testPassword',
}

[PUT] Update the logged-in user

# Species

BaseURL/api/species [GET] - gets all plant species

| Name                    | Type    | Required | Notes                             |
| ----------------------- | --------| -------- | --------------------------------- |
| species_id              | integer | yes      | The id of plant species           |
| plant_name              | string  | yes      | The name of the plant             |
| plant_scientific_name   | string  | yes      | The name of the species           |
| plant_image             | string  | no       | url to plant image                |
| water_id                | integer | yes      | water frequency                   |

RETURNS: 
{
    species_id: 1,
    plant_name: "Fern",
    plant_scientific_name: "Fernus fernia",
    plant_image: "https://plantimage.com/jpg",
    water_schedule: "Once Per Week"
}

# User plants

| Name           | Type    | Required | Notes                             |
| -------------- | ------- | -------- | --------------------------------- |
| user_plant_id  | integer | yes      | The id of the user's plant        |
| plant_nickname | string  | yes      | The user's nickname of the plant  |
| water_day      | integer | yes      | Day of week to start watering     |
| plant_location | string  | no       | location of the plant             |
| notes          | string  | no       | User's notes about the plant      |
| species_id     | integer | yes      | Plant species                     |
| user_id        | integer | yes      | User's id                         |

BaseURL/api/userplants [GET]
returns array of user's plant objects: 
[
    {
        user_plant_id: 1,
        plant_nickname: "My favorite plant",
        plant_location: "front door",
        water_day: 2,
        notes: "Sally gave me this plant. I love it!",
        species_id: 2,
        plant_name: "Love fern",
        plant_scientific_name: "Fernius Lovernius",
        water_schedule: "Twice Per Week",
        plant_image: "http://url.com/image.jpg"
    },
]

BaseURL/api/userplants [POST] - add new plant to user's collection. Returns all user's plants

Sample POST req.body: 
{
    user_id: 1,
    species_id: 3,
    plant_nickname: "2nd favorite",
    plant_location: "Back porch",
    water_day: 5,
    notes: "It's my second favorite, but I only own two plants. So really it's my least favorite."
}

BaseURL/api/userplants [PUT] - updates plant in user's collection. Returns updated plant object

BaseURL/api/userplants [DELETE] - delete's a user's plant from their collection

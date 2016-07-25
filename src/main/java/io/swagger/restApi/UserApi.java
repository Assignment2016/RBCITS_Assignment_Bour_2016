/**
 * Service layer for Users
 * @author antoine
 */

package io.swagger.restApi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user", produces = { "application/json" })
// @Api(value = "/user", description = "the user API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-07-01T20:03:11.737Z")
public class UserApi {
	/*
	 * @ApiOperation(value = "Create user", notes =
	 * "This can only be done by the logged in user.", response = Void.class)
	 * 
	 * @ApiResponses(value = {
	 * 
	 * @ApiResponse(code = 200, message = "successful operation", response =
	 * Void.class) })
	 * 
	 * @RequestMapping(value = "", produces = { "application/xml",
	 * "application/json" },
	 * 
	 * method = RequestMethod.POST) public ResponseEntity<Void> createUser(
	 * 
	 * @ApiParam(value = "Created user object" ,required=true ) @RequestBody
	 * UserDb body ) throws NotFoundException { // do some magic! return new
	 * ResponseEntity<Void>(HttpStatus.OK); }
	 * 
	 * 
	 * @ApiOperation(value = "Creates list of users with given input array",
	 * notes = "", response = Void.class)
	 * 
	 * @ApiResponses(value = {
	 * 
	 * @ApiResponse(code = 200, message = "successful operation", response =
	 * Void.class) })
	 * 
	 * @RequestMapping(value = "/createWithArray", produces = {
	 * "application/xml", "application/json" },
	 * 
	 * method = RequestMethod.POST) public ResponseEntity<Void>
	 * createUsersWithArrayInput(
	 * 
	 * @ApiParam(value = "List of user object" ,required=true ) @RequestBody
	 * List<UserDb> body ) throws NotFoundException { // do some magic! return
	 * new ResponseEntity<Void>(HttpStatus.OK); }
	 * 
	 * 
	 * @ApiOperation(value = "Creates list of users with given input array",
	 * notes = "", response = Void.class)
	 * 
	 * @ApiResponses(value = {
	 * 
	 * @ApiResponse(code = 200, message = "successful operation", response =
	 * Void.class) })
	 * 
	 * @RequestMapping(value = "/createWithList", produces = {
	 * "application/xml", "application/json" },
	 * 
	 * method = RequestMethod.POST) public ResponseEntity<Void>
	 * createUsersWithListInput(
	 * 
	 * @ApiParam(value = "List of user object" ,required=true ) @RequestBody
	 * List<UserDb> body ) throws NotFoundException { // do some magic! return
	 * new ResponseEntity<Void>(HttpStatus.OK); }
	 * 
	 * 
	 * @ApiOperation(value = "Delete user", notes =
	 * "This can only be done by the logged in user.", response = Void.class)
	 * 
	 * @ApiResponses(value = {
	 * 
	 * @ApiResponse(code = 400, message = "Invalid username supplied", response
	 * = Void.class),
	 * 
	 * @ApiResponse(code = 404, message = "User not found", response =
	 * Void.class) })
	 * 
	 * @RequestMapping(value = "/{username}", produces = { "application/xml",
	 * "application/json" },
	 * 
	 * method = RequestMethod.DELETE) public ResponseEntity<Void> deleteUser(
	 * 
	 * @ApiParam(value = "The name that needs to be deleted",required=true
	 * ) @PathVariable("username") String username
	 * 
	 * ) throws NotFoundException { // do some magic! return new
	 * ResponseEntity<Void>(HttpStatus.OK); }
	 * 
	 * 
	 * @ApiOperation(value = "Get user by user name", notes = "", response =
	 * UserDb.class)
	 * 
	 * @ApiResponses(value = {
	 * 
	 * @ApiResponse(code = 200, message = "successful operation", response =
	 * UserDb.class),
	 * 
	 * @ApiResponse(code = 400, message = "Invalid username supplied", response
	 * = UserDb.class),
	 * 
	 * @ApiResponse(code = 404, message = "User not found", response =
	 * UserDb.class) })
	 * 
	 * @RequestMapping(value = "/{username}", produces = { "application/xml",
	 * "application/json" },
	 * 
	 * method = RequestMethod.GET) public ResponseEntity<UserDb> getUserByName(
	 * 
	 * @ApiParam(value =
	 * "The name that needs to be fetched. Use user1 for testing. ",required=
	 * true ) @PathVariable("username") String username
	 * 
	 * ) throws NotFoundException { // do some magic! return new
	 * ResponseEntity<UserDb>(HttpStatus.OK); }
	 * 
	 * 
	 * @ApiOperation(value = "Logs user into the system", notes = "", response =
	 * String.class)
	 * 
	 * @ApiResponses(value = {
	 * 
	 * @ApiResponse(code = 200, message = "successful operation", response =
	 * String.class),
	 * 
	 * @ApiResponse(code = 400, message = "Invalid username/password supplied",
	 * response = String.class) })
	 * 
	 * @RequestMapping(value = "/login", produces = { "application/xml",
	 * "application/json" },
	 * 
	 * method = RequestMethod.GET) public ResponseEntity<String>
	 * loginUser(@ApiParam(value = "The user name for login", required =
	 * true) @RequestParam(value = "username", required = true) String username
	 * 
	 * 
	 * ,
	 * 
	 * @ApiParam(value = "The password for login in clear text", required =
	 * true) @RequestParam(value = "password", required = true) String password
	 * 
	 * 
	 * ) throws NotFoundException { // do some magic! return new
	 * ResponseEntity<String>(HttpStatus.OK); }
	 * 
	 * 
	 * @ApiOperation(value = "Logs out current logged in user session", notes =
	 * "", response = Void.class)
	 * 
	 * @ApiResponses(value = {
	 * 
	 * @ApiResponse(code = 200, message = "successful operation", response =
	 * Void.class) })
	 * 
	 * @RequestMapping(value = "/logout", produces = { "application/xml",
	 * "application/json" },
	 * 
	 * method = RequestMethod.GET) public ResponseEntity<Void> logoutUser()
	 * throws NotFoundException { // do some magic! return new
	 * ResponseEntity<Void>(HttpStatus.OK); }
	 * 
	 * 
	 * @ApiOperation(value = "Updated user", notes =
	 * "This can only be done by the logged in user.", response = Void.class)
	 * 
	 * @ApiResponses(value = {
	 * 
	 * @ApiResponse(code = 400, message = "Invalid user supplied", response =
	 * Void.class),
	 * 
	 * @ApiResponse(code = 404, message = "User not found", response =
	 * Void.class) })
	 * 
	 * @RequestMapping(value = "/{username}", produces = { "application/xml",
	 * "application/json" },
	 * 
	 * method = RequestMethod.PUT) public ResponseEntity<Void> updateUser(
	 * 
	 * @ApiParam(value = "name that need to be updated",required=true
	 * ) @PathVariable("username") String username
	 * 
	 * ,
	 * 
	 * 
	 * @ApiParam(value = "Updated user object" ,required=true ) @RequestBody
	 * UserDb body ) throws NotFoundException { // do some magic! return new
	 * ResponseEntity<Void>(HttpStatus.OK); }
	 */
}

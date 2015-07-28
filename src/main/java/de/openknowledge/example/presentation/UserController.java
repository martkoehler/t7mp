/*
 * Copyright 2011 Mart Köhler open knowledge GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 */
package de.openknowledge.example.presentation;

import de.openknowledge.example.business.UserService;

import javax.ejb.EJB;
import javax.inject.Named;

/**
 * @author Mart Köhler (mart.koehler@openknowledge.de)
 */
@Named("userController")
public class UserController {

  private String name;

  @EJB
  private UserService userService;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGreeting() {
    return userService.ﬁndByName(name).greet();
  }

  public Outcome addUser() {
    userService.addUser(getName());
    return Outcome.SUCCESS.facesRedirect().includeViewParams();
  }


}

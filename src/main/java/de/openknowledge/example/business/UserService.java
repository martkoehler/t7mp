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
package de.openknowledge.example.business;

import de.openknowledge.example.persistence.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * @author Mart Köhler (mart.koehler@openknowledge.de)
 */
@Stateless
public class UserService {
  @PersistenceContext
  private EntityManager em;

  public void addUser(String name) {
    User user = new User(name);
    em.persist(user);
  }

  public User ﬁndByName(String name) {
    TypedQuery<User> query = em.createNamedQuery("userByName", User.class);
    query.setParameter("name", name);
    return query.getSingleResult();
  }
}

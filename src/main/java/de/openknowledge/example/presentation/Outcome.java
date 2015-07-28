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


/**
 * @author Mart Köhler (mart.koehler@openknowledge.de)
 */
public class Outcome {

  public static final Outcome SUCCESS = new Outcome("success");
  public static final Outcome FAILURE = new Outcome("failure");

  private String outcome;

  public Outcome(String outcome) {
    this.outcome = outcome;
  }

  public Outcome facesRedirect() {
    return new Outcome(outcome + getSeparator() + "faces-redirect=true");
  }

  public Outcome includeViewParams() {
    return new Outcome(outcome + getSeparator() + "includeViewParams=true");
  }

  public String toString() {
    return outcome;
  }

  private String getSeparator() {
    return outcome.contains("?") ? "&" : "?";
  }
}

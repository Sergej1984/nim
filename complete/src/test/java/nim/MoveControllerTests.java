/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nim;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

//@RunWith(SpringRunner.class)
//@SpringBootTest
@AutoConfigureMockMvc
// @EnableAutoConfiguration(exclude = {CommandLineRunner.class}) // TODO how to get rid of CommandLineRunner in test?
public class MoveControllerTests {
    /*
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void noParamGreetingShouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.matchesOnTable").value("0"));
    }
    
    @Test
    public void paramGreetingShouldReturnTailoredMessage() throws Exception {
        this.mockMvc.perform(get("/greeting").param("matchesOnTableValue", "13")).andDo(print())
                .andExpect(status().isOk()).andExpect(jsonPath("$.matchesOnTable").value("13"));
    }
    */
}
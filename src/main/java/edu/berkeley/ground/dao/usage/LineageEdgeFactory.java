/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package edu.berkeley.ground.dao.usage;

import edu.berkeley.ground.dao.versions.ItemFactory;
import edu.berkeley.ground.exceptions.GroundException;
import edu.berkeley.ground.model.models.Tag;
import edu.berkeley.ground.model.usage.LineageEdge;

import java.util.List;
import java.util.Map;

public interface LineageEdgeFactory extends ItemFactory<LineageEdge> {

  LineageEdge create(String name, String sourceKey, Map<String, Tag> tags) throws GroundException;

  @Override
  default Class<LineageEdge> getType() {
    return LineageEdge.class;
  }

  @Override
  LineageEdge retrieveFromDatabase(String sourceKey) throws GroundException;

  @Override
  LineageEdge retrieveFromDatabase(long id) throws GroundException;

  @Override
  void update(long itemId, long childId, List<Long> parentIds) throws GroundException;

  @Override
  List<Long> getLeaves(String sourceKey) throws GroundException;

  static LineageEdge construct(long id, String name, String sourceKey, Map<String, Tag> tags) {
    return new LineageEdge(id, name, sourceKey, tags);
  }
}

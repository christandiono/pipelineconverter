package Galaxy.Tree.Workflow;

import java.util.Map;


import com.google.gson.annotations.SerializedName;

public class Workflow {
		@SerializedName("a_galaxy_workflow")
		private Boolean aGalaxyWorkflow;
		@SerializedName("annotation")
		private String annotation;
		@SerializedName("format-version")
		private Double formatVersion;
		@SerializedName("name")
		private String name;
		private Map<Integer, Step> steps;
		class Step{
			@SerializedName("annotation")
			private String annotation;
			@SerializedName("id")
			private Integer id;
			@SerializedName("name")
			private String name;
			@SerializedName("tool_state")
			private State toolState;
			
		}
		

}

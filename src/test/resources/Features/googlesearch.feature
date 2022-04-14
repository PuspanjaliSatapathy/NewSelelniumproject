@smoketest3
Feature: Testonthe google searchpage

  @tag1
  Scenario: verify the seraching random text on googlesearch
	Given User set other precondition
	Scenario Outline: Verify user able to get the list of names in google search
   Given User launched "googlesearch"
   Then User verify "GlSearch" page is loaded
   When User enter "<username>" into textbox "googlesearchbox"
   And User hit "ENTER" on "submit"
 	 Then User verify "GlSearchrResult" page is loaded
 	 Then User verify "1st-result" contains Text "<SerachSite>"
 	 And User hit browser button "back"
 	 
 
 	     Examples: 
      | username | SerachSite |
      | Arnold |Wikipedia |
      | Rambo |Wikipedia | 
      | Subhankar Panigrahi |    LinkedIn |
      | Shibby |     Linkedin | 
 	   	       
   Scenario: verify the seraching random text on googlesearch1
   Given User launched "googlesearch"
   Then User verify "GlSearch" page is loaded
   When User enter "TOM" into textbox "googlesearchbox"
   And User hit "ENTER" on "submit"
 	 Then User verify "GlSearchrResult" page is loaded
 	 Then User verify "1st-result" contains Text "Wikipedia"
 	 And User hit browser button "back"
 	 
 	 Scenario: verify the seraching random text on googlesearch1
   Given User launched "googlesearch"
   Then User verify "GlSearch" page is loaded
   When User enter "name" into textbox "googlesearchbox" and verify "1st-result" contains Text "Wikipedia" on "GlSearchrResult" page
 	 And User hit browser button "back"
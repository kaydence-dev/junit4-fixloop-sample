# junit4-fixloop-sample

A JUnit 4 Maven project that **deliberately exercises the CI-verification fix loop**.

- CI runs `mvn -B verify` = **tests + strict import checkstyle** (push + pull_request).
- On `main` (JUnit 4) the imports are clean/ordered → **CI green** (the baseline).
- The migration agent validates with `mvn test` (no checkstyle), so it opens a
  green-looking PR — but the 4→5 import rewrite breaks the alphabetical `ImportOrder`
  (and may leave an unused import), so the **PR's `mvn verify` goes red**.
- That regression (green on base, red on PR) is what the CI-verification step
  catches → it runs the **Fix CI failures** sub-agent to clean up imports →
  re-pushes → CI re-runs → green.

Run a Kaydence campaign on this repo to watch the fix loop iterate.
